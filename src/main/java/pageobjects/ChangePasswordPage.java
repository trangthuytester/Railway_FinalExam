package pageobjects;

import dataobjects.User;
import org.openqa.selenium.By;

import static common.constant.MessageConstants.CHANGEPASSWORD_SUCCESSFULLYMESSAGE;

public class ChangePasswordPage extends BasePage{

    protected By byTxtCurrentPassword = By.id("currentPassword");
    protected By byTxtNewPassword = By.id("newPassword");
    protected By byTxtConfirmNewPassword = By.id("confirmPassword");
    protected By byBtnChangePassword
            = By.xpath("//input[@title='Change password']");

    private By byChangePasswordSuccessfullyMessage = By.xpath(
            "//p[normalize-space(.)='" + CHANGEPASSWORD_SUCCESSFULLYMESSAGE.trim() + "']");

    public boolean isAtChangePasswordPage() {
        return helper.getCurrentUrl(TabName.CHANGE_PASSWORD.getValue());
    }

    public void enterCurrentPasswordAndNewPassword(String currentPassword, String newPassword, String confirmNewPassword) {
        helper.sendKeys(byTxtCurrentPassword, currentPassword);
        helper.sendKeys(byTxtNewPassword, newPassword);
        helper.sendKeys(byTxtConfirmNewPassword, confirmNewPassword);
    }

    public void clickChangePasswordButton() {
        helper.clickElement(byBtnChangePassword);
    }

    public HomePage changePassword(User user) {
        goToChangePasswordPage();
        enterCurrentPasswordAndNewPassword(user.getCurrentPassword(), user.getNewPassword(), user.getConfirmNewPassword());
        clickChangePasswordButton();
        return new HomePage();
    }

    public boolean isChangePasswordSuccessfullyMessageDisplayed() {
        return helper.isDisplayed(byChangePasswordSuccessfullyMessage);
    }

}
