package common.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserManager {
    public static void openNewTabAndSwitch(String url) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.open('" + url + "','_blank');");

        ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void switchToLastTab() {
        WebDriver driver = DriverManager.getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
