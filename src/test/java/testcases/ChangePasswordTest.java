package testcases;

import dataobjects.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.ChangePasswordPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static common.constant.UserConstants.*;

public class ChangePasswordTest extends TestBase{
    @Test(description = "Change password successfully")
    public void tc9_ChangePasswordSuccessfully_test() {
        SoftAssert soft = new SoftAssert();

        LoginPage loginPage = new LoginPage();
        User validUser = new User(VALID_USERNAME_CHANGEPASSWORD, VALID_CURRENTPASSWORD_CHANGEPASSWORD);
        HomePage homePage = loginPage.loginAccount(validUser);

        soft.assertTrue(
                homePage.isWelcomeMessageDisplayed(validUser),
                "Welcome message is not displayed!");

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        User changePasswordUser = new User(VALID_CURRENTPASSWORD_CHANGEPASSWORD, VALID_NEWPASSWORD_CHANGEPASSWORD, VALID_NEWPASSWORD_CHANGEPASSWORD);
        changePasswordPage.changePassword(changePasswordUser);

        soft.assertTrue(
                changePasswordPage.isAtChangePasswordPage(),
                "Did not navigate to Change Password page!");

        soft.assertTrue(
                changePasswordPage.isChangePasswordSuccessfullyMessageDisplayed(),
                "Change password successfully message is not displayed!");
        try {
            User resetPasswordUser = new User(
                    VALID_NEWPASSWORD_CHANGEPASSWORD,
                    VALID_CURRENTPASSWORD_CHANGEPASSWORD,
                    VALID_CURRENTPASSWORD_CHANGEPASSWORD);
            changePasswordPage.changePassword(resetPasswordUser);
        } catch (Exception e) {
            System.out.println("⚠️ WARNING: Reset password back to original failed. Please check manually. " + e.getMessage());
        }
        soft.assertAll();
    }

}
