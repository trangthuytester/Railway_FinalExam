package pageobjects;

import common.utility.ElementHelper;
import dataobjects.User;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage extends BasePage{
    protected ElementHelper helper;

    public boolean isWelcomeMessageDisplayed(User user) {
        String expectedMessage = "Welcome\\s+" + Pattern.quote(user.getUsername());
        String actualMessage = helper.findElement(By.xpath("//div[@class='account']/strong"))
                .getText();
        Pattern pattern = Pattern.compile(expectedMessage);
        Matcher matcher = pattern.matcher(actualMessage);
        return matcher.matches();
    }

}
