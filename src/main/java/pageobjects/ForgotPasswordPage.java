package pageobjects;

import org.openqa.selenium.By;

import static common.constant.MessageConstants.INSTRUCTION_MESSAGE;

public class ForgotPasswordPage extends BasePage{
    protected By byBtnSendInstructions = By.xpath("//input[@value='Send Instructions']");
    protected By byTxtEmail = By.id("email");
    private By byPasswordResetInstructionsMessage = By.xpath(
            "//p[normalize-space(.)='" + INSTRUCTION_MESSAGE.trim() + "']");

    public void enterEmail(String email) {
        helper.sendKeys(byTxtEmail, email);
    }

    public void clickSendInstructionsButton() {
        helper.clickElement(byBtnSendInstructions);
    }

    public void WatchInstructionToResetPassword(String email) {
        enterEmail(email);
        clickSendInstructionsButton();
    }

    public boolean isPasswordResetInstructionsMessage() {
        return helper.isDisplayed(byPasswordResetInstructionsMessage);
    }

}
