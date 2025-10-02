package pageobjects;

import common.utility.ElementHelper;
import dataobjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.constant.MessageConstants.*;
import static common.utility.ElementHelper.scrollToElement;


public class LoginPage extends BasePage {
    protected ElementHelper helper;
    protected By byTxtUsername = By.id("username");
    protected By byTxtPassword = By.id("password");
    protected By byBtnLogin = By.xpath("//input[@title='Login']");

    public void enterUsernamePassword(String username, String password) {
        helper.sendKeys(byTxtUsername, username);
        helper.sendKeys(byTxtPassword, password);
    }

    public void clickLoginButton() {
        helper.clickElement(byBtnLogin);
    }

    public HomePage loginAccount(User user) {
        goToLoginPage();
        enterUsernamePassword(user.getUsername(), user.getPassword());
        clickLoginButton();
        return new HomePage();
    }

}
