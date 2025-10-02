package pageobjects;

import common.driver.DriverManager;
import common.utility.ElementHelper;
import org.openqa.selenium.By;

import static common.constant.MessageConstants.*;
import static common.constant.TimeConstants.WAIT_TIME;

public class PasswordResetPage extends BasePage {
    private final ElementHelper helper;
    private final By byNewPasswordInput = By.id("newPassword");
    private final By byConfirmPasswordInput = By.id("confirmPassword");
    private final By byResetTokenInput = By.id("resetToken");
    private final By byBtnResetPassword = By.xpath("//input[@title='Reset password']");
    private final By byErrorMessageResetPasswordBlank1 = By.xpath(
            "//p[@class='message error'][normalize-space(.)='"
                    + RESETPASSWORDWITH_BLANKRESETPASSWORD_ERRORMESSAGE_1.trim() + "']");
    private final By byErrorMessageResetPasswordBlank2 = By.xpath(
            "//label[@for='resetToken' and normalize-space(text())='"
                    + RESETPASSWORDWITH_BLANKRESETPASSWORD_ERRORMESSAGE_2.trim() + "']");
    private final By byErrorMessageResetPasswordPasswordAndResetPasswordNotMatch1 = By.xpath(
            "//p[@class='message error'][normalize-space(.)='"
                    + RESETPASSWORDWITH_PASSWORDCONFIRMPASSWORDNOTMATCH_ERRORMESSAGE_1.trim() + "']");
    private final By byErrorMessageResetPasswordPasswordAndResetPasswordNotMatch2 = By.xpath(
            "//label[@for='confirmPassword' and normalize-space(text())='"
                    + RESETPASSWORDWITH_PASSWORDCONFIRMPASSWORDNOTMATCH_ERRORMESSAGE_2.trim() + "']");

    public PasswordResetPage() {
        helper = new ElementHelper(DriverManager.getDriver());
    }

    public void enterNewPassword(String password) {
        helper.sendKeys(byNewPasswordInput, password);
    }

    public void enterConfirmPassword(String password) {
        helper.sendKeys(byConfirmPasswordInput, password);
    }

    public void fillPassword(String password) {
        helper.waitAndScrollToElement(byNewPasswordInput, WAIT_TIME);
        enterNewPassword(password);
        enterConfirmPassword(password);
    }

    public void clearResetToken() {
        helper.clearText(byResetTokenInput);
    }

    public void clickResetPasswordButton() {
        helper.clickElement(byBtnResetPassword);
    }

    public void fillPasswordAndClearToken(String password) {
        fillPassword(password);
        clearResetToken();
    }

    public void ResetPasswordWithBlankToken(String password) {
        fillPasswordAndClearToken(password);
        clickResetPasswordButton();
    }

    public void fillPasswordAndConfirmPassword(String password, String confirmPassword) {
        helper.waitAndScrollToElement(byNewPasswordInput, WAIT_TIME);
        enterNewPassword(password);
        enterConfirmPassword(confirmPassword);
    }

    public void ResetPasswordWithPasswordAndConfirmPasswordNotMatch(String password, String confirmPassword) {
        fillPasswordAndConfirmPassword(password, confirmPassword);
        clickResetPasswordButton();
    }

    public boolean isErrorMessageDisplayedWithResetPasswordTokenBlank() {
        return helper.isDisplayed(byErrorMessageResetPasswordBlank1) &&
                helper.isDisplayed(byErrorMessageResetPasswordBlank2);
    }

    public boolean isErrorMessageDisplayedWithPasswordConfirmPasswordNotMatch() {
        return helper.isDisplayed(byErrorMessageResetPasswordPasswordAndResetPasswordNotMatch1) &&
                helper.isDisplayed(byErrorMessageResetPasswordPasswordAndResetPasswordNotMatch2);

    }

}
