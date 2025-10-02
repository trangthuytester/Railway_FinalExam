package testcases;

import common.driver.BrowserManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.ForgotPasswordPage;
import pageobjects.GuerrillaMailPage;
import pageobjects.LoginPage;
import pageobjects.PasswordResetPage;

import static common.constant.GlobalConstants.MAIL_URL;
import static common.constant.UserConstants.*;

public class ResetPasswordTest extends TestBase{

    @Test(description = "Reset password failed with blank Reset token")
    public void tc12_ErrorsDisplayWhenPasswordResetTokenIsBlank() {
        SoftAssert soft = new SoftAssert();
        LoginPage loginPage = new LoginPage();
        loginPage.loginTab();
        ForgotPasswordPage forgotPasswordPage = loginPage.goToForgotPasswordPage();
        forgotPasswordPage.WatchInstructionToResetPassword(VALID_MAIL);
        soft.assertTrue(
                forgotPasswordPage.isPasswordResetInstructionsMessage(),
                "Expected Instruction message not displayed.");

        BrowserManager.openNewTabAndSwitch(MAIL_URL);
        GuerrillaMailPage guerrillaMailPage = new GuerrillaMailPage();
        soft.assertTrue(
                guerrillaMailPage.getPageTitle().contains("Guerrilla"),
                "Cannot open Guerrilla Mail!"
        );
        guerrillaMailPage.setMail(VALID_NAME, VALID_DOMAIN);
        guerrillaMailPage.resetPassword();
        BrowserManager.switchToLastTab();
        PasswordResetPage passwordResetPage = new PasswordResetPage();
        passwordResetPage.ResetPasswordWithBlankToken(VALID_PASSWORD);
        soft.assertTrue(
                passwordResetPage.isErrorMessageDisplayedWithResetPasswordTokenBlank(),
                "Expected Reset Password error message not displayed.");
        soft.assertAll();
    }

    @Test(description = "Reset password failed with Password and Confirm password not match")
    public void tc13_ResetPasswordWithPasswordAndConfirmPasswordNotMatch() {
        SoftAssert soft = new SoftAssert();
        LoginPage loginPage = new LoginPage();
        loginPage.loginTab();
        ForgotPasswordPage forgotPasswordPage = loginPage.goToForgotPasswordPage();
        forgotPasswordPage.WatchInstructionToResetPassword(VALID_MAIL);
        soft.assertTrue(
                forgotPasswordPage.isPasswordResetInstructionsMessage(),
                "Expected Instruction message not displayed.");

        BrowserManager.openNewTabAndSwitch(MAIL_URL);
        GuerrillaMailPage guerrillaMailPage = new GuerrillaMailPage();
        soft.assertTrue(
                guerrillaMailPage.getPageTitle().contains("Guerrilla"),
                "Cannot open Guerrilla Mail!"
        );
        guerrillaMailPage.setMail(VALID_NAME, VALID_DOMAIN);
        guerrillaMailPage.resetPassword();
        BrowserManager.switchToLastTab();
        PasswordResetPage passwordResetPage = new PasswordResetPage();
        passwordResetPage.ResetPasswordWithPasswordAndConfirmPasswordNotMatch(VALID_PASSWORD, INVALID_PASSWORD);
        soft.assertTrue(
                passwordResetPage.isErrorMessageDisplayedWithPasswordConfirmPasswordNotMatch(),
                "Expected Reset Password error message not displayed.");
        soft.assertAll();
    }

}
