package pageobjects;

import common.utility.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.constant.GlobalConstants.PASSWORD_RESET_URL;
import static common.constant.MessageConstants.RESETPASSWORD_MAIL;
import static common.constant.TimeConstants.WAIT_TIME;
import static common.constant.UserConstants.VALID_DOMAIN;
import static common.driver.DriverManager.getDriver;

public class GuerrillaMailPage extends BasePage {
    private final ElementHelper helper;
    private final By byInboxIdSpan = By.xpath("//span[@id='inbox-id']");
    private final By byInboxIdInput = By.xpath("//span[@id='inbox-id']/input");
    private final By bySetButton = By.xpath("//button[contains(text(), 'Set')]");
    private final By byHostDropdown = By.xpath("//select[@id='gm-host-select']");
    private final By byDomainOption = By.xpath("//select/option[@value='" + VALID_DOMAIN + "']");
    private final By byResetPasswordMail = By.xpath("//td[contains(text(),'" + RESETPASSWORD_MAIL +"')]");
    private final By byResetPasswordLink = By.xpath("//a[contains(@href, '" + PASSWORD_RESET_URL + "')]");
    private final By overlayLocator = By.cssSelector("div.status_alert");

    public GuerrillaMailPage() {
        helper = new ElementHelper(getDriver());
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void changeInboxName(String newName) {
        helper.clickElement(byInboxIdSpan);
        helper.sendKeys(byInboxIdInput, newName);
        helper.clickElement(bySetButton);
    }

    public void selectDomain(String domain) {
        helper.clickElement(byHostDropdown);
        helper.clickElement(byDomainOption);
    }
    public void setMail(String newName, String domain) {
        changeInboxName(newName);
        selectDomain(domain);
    }

    public void openResetPasswordMail() {
        helper.waitForElementVisible(byResetPasswordMail, WAIT_TIME).click();
    }

    public void clickResetPasswordLink() {
        helper.waitForElementToDisappear(overlayLocator, WAIT_TIME);
        WebElement resetPasswordLink = helper.waitAndScrollToElement(byResetPasswordLink, WAIT_TIME);
        resetPasswordLink.click();
    }

    public void resetPassword() {
        openResetPasswordMail();
        clickResetPasswordLink();
    }
}
