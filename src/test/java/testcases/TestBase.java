package testcases;

import common.constant.GlobalConstants;
import common.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    protected WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        System.out.println("Before test: start browser - " + browser);

        DriverManager.createDriverFor(browser);
        driver = DriverManager.getDriver();
        DriverManager.navigateTo(GlobalConstants.BASE_URL);
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }

}