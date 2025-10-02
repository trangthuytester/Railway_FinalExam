package pageobjects;

import common.constant.enums.BookedTicketColumn;
import common.utility.ElementHelper;
import dataobjects.Ticket;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static common.constant.MessageConstants.*;
import static common.constant.TimeConstants.WAIT_TIME;

public class MyTicketPage extends BasePage{
    protected ElementHelper helper;
    private By departDateInput = By.xpath("//input[@name='FilterDpDate']");
    private By filterButton = By.xpath("//input[@type='submit']");
    private String departDateResult =
            "//table[@class='MyTable']//tr/td[count(//table[@class='MyTable']//th[text()='%s']/preceding-sibling::th)+1]";
    private By noTicketMessage = By.xpath(
            "//div[@class='error message' and normalize-space(string(.)) = \"" + NOTICKETERRORMESSAGE + "\"]"
    );
    private By currentTicketMessage = By.xpath(
            "//div[@class='message']//li[normalize-space(.)='" + CURRENTTICKETMESSAGE + "']"
    );
    private By byBtnCancelTicket(String ticketId) {
        return By.xpath("//input[@value='Cancel'][@onclick='DeleteTicket(" + ticketId + ");']");
    }

    public void cancelTicketById(String ticketId) {
        By cancelButton = byBtnCancelTicket(ticketId);
        helper.clickAndAcceptAlert(cancelButton, WAIT_TIME);
        helper.waitForElementToDisappear(cancelButton, WAIT_TIME);
    }


    public boolean isTicketCancelled(String ticketId) {
        return !helper.isElementPresent(byBtnCancelTicket(ticketId));
    }

    public void filterTicketByDepartDate(String departDate) {
        enterDepartDate(departDate);
        clickFilterButton();
    }

    public void enterDepartDate(String departDate) {
        helper.sendKeys(departDateInput, departDate);
    }

    public void clickFilterButton() {
        helper.clickElement(filterButton);
    }

    private By getResultCellBy(String columnName) {
        String result = String.format(departDateResult, columnName);
        return By.xpath(result);
    }

    public String getDepartDateResult() {
        return helper.findElement(getResultCellBy("Depart Date")).getText().trim();
    }

    public String getDepartStationResult() {
        return helper.findElement(getResultCellBy("Depart Station")).getText().trim();
    }

    public String getArriveStationResult() {
        return helper.findElement(getResultCellBy("Arrive Station")).getText().trim();
    }

    public String getSeatTypeResult() {
        return helper.findElement(getResultCellBy("Seat Type")).getText().trim();
    }

    public String getAmountResult() {
        return helper.findElement(getResultCellBy("Amount")).getText().trim();
    }

    public void assertFilterMatches(Ticket expectedTicket, String filterDate, SoftAssert soft) {
        soft.assertTrue(
                getDepartDateResult().equals(filterDate),
                "Depart Date mismatch! Expected: " + filterDate + " but got: " + getDepartDateResult()
        );

        soft.assertTrue(
                getDepartStationResult().equals(expectedTicket.getDepartStation().getDepart()),
                "Depart Station mismatch! Expected: " + expectedTicket.getDepartStation().getDepart() +
                        " but got: " + getDepartStationResult()
        );

        soft.assertTrue(
                getArriveStationResult().equals(expectedTicket.getArriveStation().getDepart()),
                "Arrive Station mismatch! Expected: " + expectedTicket.getArriveStation().getDepart() +
                        " but got: " + getArriveStationResult()
        );

        soft.assertTrue(
                getSeatTypeResult().equals(expectedTicket.getSeatType().getDisplayName()),
                "Seat Type mismatch! Expected: " + expectedTicket.getSeatType().getDisplayName() +
                        " but got: " + getSeatTypeResult()
        );

        soft.assertTrue(
                getAmountResult().equals(String.valueOf(expectedTicket.getTicketAmount())),
                "Amount mismatch! Expected: " + expectedTicket.getTicketAmount() +
                        " but got: " + getAmountResult()
        );

    }

    public boolean isErrorMessageDisplayedWithNoTicket() {
        return helper.isDisplayed(noTicketMessage);
    }

    public boolean isCurrentTicketMessageDisplayedWithNoTicket() {
        return helper.isDisplayed(currentTicketMessage);
    }


}
