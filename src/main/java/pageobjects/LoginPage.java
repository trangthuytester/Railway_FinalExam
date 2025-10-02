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
    private final By byForgotPasswordLink = By.xpath("//a[contains(@href, 'ForgotPassword')]");
    private By byErrorMessageUsernameBlank_or_InvalidPassword = By.xpath(
            "//p[normalize-space(.)='" + BLANK_OR_INVALID_ERRORMESSAGE.trim() + "']");

    private By byErrorMessageSeveralTimeInvalidPassword = By.xpath(
            "//p[normalize-space(.)='" + SEVERAL_TIME_INVALID_ERRORMESSAGE.trim() + "']");

    private By byErrorMessageInactivatedAccount = By.xpath(
            "//p[normalize-space(.)='" + INACTIVATED_ACCOUNT_ERRORMESSAGE.trim() + "']");

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

    public HomePage loginTab() {
        goToLoginPage();
        return new HomePage();
    }

    public boolean isLoginErrorMessageDisplayedWithBlankUsername_or_InvalidPassword() {
        return helper.isDisplayed(byErrorMessageUsernameBlank_or_InvalidPassword);
    }

    public boolean isLoginErrorMessageDisplayedWithSeveralTimeInvalidPassword() {
        return helper.isDisplayed(byErrorMessageSeveralTimeInvalidPassword);
    }

    public boolean isLoginErrorMessageDisplayedWithInactivedAccount() {
        return helper.isDisplayed(byErrorMessageInactivatedAccount);
    }

    public boolean isAtLoginPage() {
        return helper.getCurrentUrl("Login");
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        WebElement forgotPasswordLink = helper.findElement(byForgotPasswordLink);
        scrollToElement(forgotPasswordLink);
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

}
