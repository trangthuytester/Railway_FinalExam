package common.utility;

import common.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static common.driver.DriverManager.getDriver;

public class ElementHelper {

    public ElementHelper(WebDriver driver) {
    }

    public static WebElement findElement(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    public static void clickElement(By locator) {
        findElement(locator).click();
    }

    public static void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public static boolean isDisplayed(By locator) {
        List<WebElement> elements = DriverManager.getDriver().findElements(locator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public static boolean getCurrentUrl(String currentURL) {
        return DriverManager.getDriver().getCurrentUrl().contains(currentURL);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getSelectedOptionText(By locator) {
        WebElement element = findElement(locator);
        return new Select(element).getFirstSelectedOption().getText().trim();
    }


    public void selectDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }


    public boolean isElementPresent(By locator) {
        return !getDriver().findElements(locator).isEmpty();
    }

    public static void clickAndAcceptAlert(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void waitForElementToDisappear(By overlayLocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }

}
