package testcases;

import dataobjects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.*;

import static common.constant.UserConstants.*;
import static helpers.TestHelper.loginSeveralTimesWithInvalidPassword;

public class LoginTest extends TestBase {

    @Test(description = "Login successfully")
    public void tc1_LoginWithValidCredentials_test() {
        LoginPage loginPage = new LoginPage();
        User validUser = new User(VALID_USERNAME, VALID_PASSWORD);
        HomePage homePage = loginPage.loginAccount(validUser);
        Assert.assertTrue(
                homePage.isWelcomeMessageDisplayed(validUser),
                "Welcome message is not displayed!");
    }

    @Test(description = "Login failed with blank Username")
    public void tc2_LoginWithBlankUsername_test() {
        LoginPage loginPage = new LoginPage();
        User blankUsernameUser = new User(BLANK_USERNAME, VALID_PASSWORD);
        loginPage.loginAccount(blankUsernameUser);
        Assert.assertTrue(
                loginPage.isLoginErrorMessageDisplayedWithBlankUsername_or_InvalidPassword(),
                "Expected login error message not displayed.");
    }

    @Test(description = "Login failed with invalid password")
    public void tc3_LoginWithInvalidPassword_test() {
        LoginPage loginPage = new LoginPage();
        User invalidPasswordUser = new User(VALID_USERNAME, INVALID_PASSWORD);
        loginPage.loginAccount(invalidPasswordUser);
        Assert.assertTrue(
                loginPage.isLoginErrorMessageDisplayedWithBlankUsername_or_InvalidPassword(),
                "Expected login error message not displayed.");
    }

    @Test(description = "Click Book ticket tab without login")
    public void tc4_ClickingBookTicketTabWithoutLogin_test() {
        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.goToBookTicketPage();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(
                loginPage.isAtLoginPage(),
                "Not navigate to Log in page");
    }

    @Test(description = "Login failed with many times input wrong password")
    public void tc5_WrongPasswordSeveralTimes_test() {
        LoginPage loginPage = new LoginPage();
        User invalidPasswordUser = new User(VALID_USERNAME, INVALID_PASSWORD);
        loginSeveralTimesWithInvalidPassword(loginPage, invalidPasswordUser, INVALID_LOGIN_ATTEMPTS);
        Assert.assertTrue(
                loginPage.isLoginErrorMessageDisplayedWithSeveralTimeInvalidPassword(),
                "Expected login error message not displayed.");
    }


    @Test(description = "Additional pages are appeared after logining")
    public void tc6_AdditionalPagesDisplay_test() {
        SoftAssert soft = new SoftAssert();

        LoginPage loginPage = new LoginPage();
        User validUser = new User(VALID_USERNAME, VALID_PASSWORD);
        HomePage homePage = loginPage.loginAccount(validUser);

        soft.assertTrue(
                homePage.isWelcomeMessageDisplayed(validUser),
                "Welcome message is not displayed!");

        soft.assertTrue(
                homePage.areAdditionalTabsDisplayed(),
                "'My ticket', 'Change password' and 'Logout' tabs are not displayed!");

        MyTicketPage myTicketPage = homePage.goToMyTicketPage();
        soft.assertTrue(
                myTicketPage.isAtMyTicketPage(),
                "Did not navigate to My Ticket page!");

        ChangePasswordPage changePasswordPage = myTicketPage.goToChangePasswordPage();
        soft.assertTrue(
                changePasswordPage.isAtChangePasswordPage(),
                "Did not navigate to Change Password page!");

        soft.assertAll();
    }

    @Test(description = "Login failed with inactived account")
    public void tc8_LoginWithInactivatedAccount_test() {
        LoginPage loginPage = new LoginPage();
        User inactivedUser = new User(INACTIVATED_USERNAME, INACTIVATED_PASSWORD);
        loginPage.loginAccount(inactivedUser);
        Assert.assertTrue(
                loginPage.isLoginErrorMessageDisplayedWithInactivedAccount(),
                "Expected login error message not displayed.");
    }

}
