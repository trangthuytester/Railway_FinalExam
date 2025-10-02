package pageobjects;

import common.utility.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage{
    protected ElementHelper helper;
    private By getBookTicketLink(String depart, String arrive) {
        String bookTicketLink = String.format("//tr[td[2]='%s'][td[3]='%s']//a[contains(@href, 'BookTicket')]", depart, arrive);
        return By.xpath(bookTicketLink);
    }

    public BookTicketPage clickBookTicketLink(String depart, String arrive) {
        By dynamicLocator = getBookTicketLink(depart, arrive);
        WebElement bookTicketLink = ElementHelper.findElement(dynamicLocator);
        helper.scrollToElement(bookTicketLink);
        bookTicketLink.click();
        return new BookTicketPage();
    }
}
