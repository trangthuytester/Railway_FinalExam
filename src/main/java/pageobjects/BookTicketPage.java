package pageobjects;

import common.constant.enums.BookedTicketColumn;
import common.driver.DriverManager;
import common.utility.DateUtils;
import common.utility.ElementHelper;
import dataobjects.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static common.utility.ElementHelper.scrollToElement;

public class BookTicketPage extends BasePage {
    private final ElementHelper helper;

    private final By byDdDepartFrom = By.name("DepartStation");
    private final By byDdArriveAt = By.name("ArriveStation");
    private final By byDdDepartDate = By.name("Date");
    private final By byDdSeatType = By.name("SeatType");
    private final By byDdAmount = By.name("TicketAmount");
    private final By byBtnBookTicket = By.xpath("//input[@value='Book ticket']");

    public BookTicketPage() {
        helper = new ElementHelper(DriverManager.getDriver());
    }

    public boolean isDepartAndArrive(String expectedDepart, String expectedArrive) {
        return helper.getSelectedOptionText(byDdDepartFrom).equals(expectedDepart)
                && helper.getSelectedOptionText(byDdArriveAt).equals(expectedArrive);
    }

    public void selectDepartDatePlusDays(String formattedDate) {
        WebElement departDateDropdown = helper.findElement(byDdDepartDate);
        scrollToElement(departDateDropdown);
        helper.selectDropdownByVisibleText(byDdDepartDate, formattedDate);
    }

    public void selectDepartAndArrive(Ticket ticket) {
        helper.selectDropdownByVisibleText(byDdDepartFrom, ticket.getDepartStation().getDepart());
        helper.selectDropdownByVisibleText(byDdArriveAt, ticket.getArriveStation().getDepart());
    }

    public void selectSeatType(Ticket ticket) {
        helper.selectDropdownByVisibleText(byDdSeatType, ticket.getSeatType().getDisplayName());
    }

    public void selectTicketAmount(Ticket ticket) {
        helper.selectDropdownByVisibleText(byDdAmount, String.valueOf(ticket.getTicketAmount()));
    }

    public void clickBookTicketButton() {
        helper.clickElement(byBtnBookTicket);
    }

    public void bookTicket(Ticket ticket) {
        goToBookTicketPage();
        selectDepartDatePlusDays(DateUtils.getFormattedDate(ticket.getDaysToAdd(), "M/d/yyyy"));
        selectDepartAndArrive(ticket);
        selectSeatType(ticket);
        selectTicketAmount(ticket);
        clickBookTicketButton();
    }

    private String getCellTextByColumn(BookedTicketColumn column) {
        String xpath = String.format(
                "//table[@class='MyTable WideTable']//tr/td[count(//table[@class='MyTable WideTable']//th[normalize-space(text())='%s']/preceding-sibling::th)+1]",
                column.getHeaderText()
        );
        return helper.getText(By.xpath(xpath));
    }

    public void assertBookedTicketMatches(Ticket ticket, SoftAssert soft) {
        soft.assertEquals(
                getCellTextByColumn(BookedTicketColumn.DEPART),
                ticket.getDepartStation().getDepart(),
                "Depart Station mismatch!"
        );
        soft.assertEquals(
                getCellTextByColumn(BookedTicketColumn.ARRIVE),
                ticket.getArriveStation().getDepart(),
                "Arrive Station mismatch!"
        );
        soft.assertEquals(
                getCellTextByColumn(BookedTicketColumn.SEAT_TYPE),
                ticket.getSeatType().getDisplayName(),
                "Seat Type mismatch!"
        );
        soft.assertEquals(
                getCellTextByColumn(BookedTicketColumn.DEPART_DATE),
                ticket.getFormattedDepartDate(),
                "Depart Date mismatch!"
        );
        soft.assertEquals(
                getCellTextByColumn(BookedTicketColumn.AMOUNT),
                String.valueOf(ticket.getTicketAmount()),
                "Amount mismatch!"
        );
    }

    public String getTicketIdFromSuccessUrl() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("id="));

        String currentSuccessUrl = DriverManager.getDriver().getCurrentUrl();
        return currentSuccessUrl.substring(currentSuccessUrl.indexOf("id=") + 3);
    }



}