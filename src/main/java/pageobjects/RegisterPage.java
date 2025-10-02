package pageobjects;

import common.utility.ElementHelper;
import dataobjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.constant.MessageConstants.*;

public class RegisterPage extends BasePage{
    protected ElementHelper helper;

    protected By bytxtEmail = By.id("email");
    protected By bytxtPassword = By.id("password");
    protected By bytxtConfirmPassword = By.id("confirmPassword");
    protected By bytxtPassportNumber = By.name("pid");
    protected By byBtnRegister = By.xpath("//input[@title='Register']");

    private By byRegisterSuccessfullyMessage = By.xpath(
            "//h1[text()='" + REGISTER_SUCCESS_MESSAGE + "']");
    private By byRegisterFailedMessage = By.xpath(
            "//p[normalize-space(.)=\"" +
                    REGISTERWITH_INVALIDCONFIRMPASSWORD_ERRORMESSAGE + "\"]");
    private By byBlankPasswordMessage = By.xpath(
            "//label[normalize-space(.)='" +
                    REGISTERWITH_BLANKPASSWORD_ERRORMESSAGE.trim() + "']");
    private By byBlankPidMessage = By.xpath(
            "//label[normalize-space(.)='" +
                    REGISTERWITH_BLANKPID_ERRORMESSAGE.trim() + "']");

    public void enterEmail(String email) {
        helper.sendKeys(bytxtEmail, email);
    }

    public void enterPasswordAndConfirmPassword(String password, String confirmPassword) {
        helper.sendKeys(bytxtPassword, password);
        helper.sendKeys(bytxtConfirmPassword, confirmPassword);
    }

    public void enterPassportNumber(String passportNumber) {
        helper.sendKeys(bytxtPassportNumber, passportNumber);
    }

    public void clickRegisterButton() {
        WebElement registerBtn = helper.findElement(byBtnRegister);
        helper.scrollToElement(registerBtn);
        helper.clickElement(byBtnRegister);
    }

    public HomePage registerAccount(User user) {
        goToRegisterPage();
        enterEmail(user.getUsername());
        enterPasswordAndConfirmPassword(user.getPassword(), user.getConfirmPassword());
        enterPassportNumber(user.getPassportNumber());
        clickRegisterButton();
        return new HomePage();
    }

    public boolean isRegisterSuccessfullyMessageDisplayed() {
        return helper.isDisplayed(byRegisterSuccessfullyMessage);
    }

    public boolean isRegisterFailedWithInvalidConfirmPasswordMessageDisplayed() {
        return helper.isDisplayed(byRegisterFailedMessage);
    }

    public boolean isRegisterFailedWithBLankFieldsMessageDisplayed() {
        return helper.isDisplayed(byRegisterFailedMessage)
                && helper.isDisplayed(byBlankPasswordMessage)
                && helper.isDisplayed(byBlankPidMessage);
    }
}
