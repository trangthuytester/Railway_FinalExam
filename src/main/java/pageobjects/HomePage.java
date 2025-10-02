package pageobjects;

import common.utility.ElementHelper;
import dataobjects.User;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage extends BasePage{
    protected By byTabTicket = By.xpath(String.format(sTabMenu, "ManageTicket"));
    protected By byTabChangePassword = By.xpath(String.format(sTabMenu, "ChangePassword"));
    protected By byTabLogout = By.xpath(String.format(sTabMenu, "Logout"));
    protected ElementHelper helper;

    public boolean isWelcomeMessageDisplayed(User user) {
        String expectedMessage = "Welcome\\s+" + Pattern.quote(user.getUsername());
        String actualMessage = helper.findElement(By.xpath("//div[@class='account']/strong"))
                .getText();
        Pattern pattern = Pattern.compile(expectedMessage);
        Matcher matcher = pattern.matcher(actualMessage);
        return matcher.matches();
    }

    public boolean areAdditionalTabsDisplayed() {
        return helper.isDisplayed(byTabTicket)
                && helper.isDisplayed(byTabChangePassword)
                && helper.isDisplayed(byTabLogout);
    }

}
