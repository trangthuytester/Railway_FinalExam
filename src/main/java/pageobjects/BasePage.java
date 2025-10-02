package pageobjects;

import common.driver.DriverManager;
import common.utility.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected String sTabMenu = "//li//a[contains(@href, '%s')]";
    protected ElementHelper helper;
    public BasePage() {
        this.helper = new ElementHelper(DriverManager.getDriver());
    }
    protected WebElement getTabElement(String tab) {
        By byTab = By.xpath(String.format(sTabMenu, tab));
        return helper.findElement(byTab);
    }

    protected void clickTab(TabName tab) {
        getTabElement(tab.getValue()).click();
    }

    public enum TabName {
        LOGIN("Login"),
        REGISTER("Register"),
        MANAGE_TICKET("ManageTicket"),
        CHANGE_PASSWORD("ChangePassword"),
        BOOK_TICKET("BookTicket"),
        TIME_TABLE("TrainTimeListPage");

        private final String value;

        TabName(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public LoginPage goToLoginPage() {
        clickTab(TabName.LOGIN);
        return new LoginPage();
    }

    public MyTicketPage goToMyTicketPage() {
        clickTab(TabName.MANAGE_TICKET);
        return new MyTicketPage();
    }

    public ChangePasswordPage goToChangePasswordPage() {
        clickTab(TabName.CHANGE_PASSWORD);
        return new ChangePasswordPage();
    }

    public BookTicketPage goToBookTicketPage() {
        clickTab(TabName.BOOK_TICKET);
        return new BookTicketPage();
    }

    public RegisterPage goToRegisterPage() {
        clickTab(TabName.REGISTER);
        return new RegisterPage();
    }

    public TimetablePage goToTimetablePage() {
        clickTab(TabName.TIME_TABLE);
        return new TimetablePage();
    }

}
