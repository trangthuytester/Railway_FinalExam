package testcases;

import dataobjects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

import static common.constant.UserConstants.*;

public class RegisterTest extends TestBase{
    @Test(description = "Create new account successfully")
    public void tc7_CreateNewAccountSuccessfully_test() {
        RegisterPage registerPage = new RegisterPage();
        User validRegisterUser = new User(VALID_EMAIL_REGISTER, VALID_PASSWORD_REGISTER, VALID_CONFIRM_PASSWORD_REGISTER, VALID_PID_REGISTER);
        registerPage.registerAccount(validRegisterUser);
        Assert.assertTrue(
                registerPage.isRegisterSuccessfullyMessageDisplayed(),
                "Create account successfully message is not displayed!");
    }

    @Test(description = "Create new account failed with invalid Confirm password")
    public void tc10_CreateNewAccountFailedWithInvalidConfirmPassword_test() {
        RegisterPage registerPage = new RegisterPage();
        User invalidRegisterUser = new User(VALID_EMAIL_REGISTER, VALID_PASSWORD_REGISTER, INVALID_CONFIRM_PASSWORD_REGISTER, VALID_PID_REGISTER);
        registerPage.registerAccount(invalidRegisterUser);
        Assert.assertTrue(
                registerPage.isRegisterFailedWithInvalidConfirmPasswordMessageDisplayed(),
                "Create account failed message is not displayed!");
    }

    @Test(description = "Create new account failed with blank Password and Pid")
    public void tc11_CreateNewAccountFailedWithPasswordAndPidEmpty_test() {
        RegisterPage registerPage = new RegisterPage();
        User invalidRegisterUser = new User(VALID_EMAIL_REGISTER, BLANK_PASSWORD_REGISTER, BLANK_CONFIRM_PASSWORD_REGISTER, BLANK_PID_REGISTER);
        registerPage.registerAccount(invalidRegisterUser);
        Assert.assertTrue(
                registerPage.isRegisterFailedWithBLankFieldsMessageDisplayed(),
                "Create account failed message is not displayed!");
    }
}
