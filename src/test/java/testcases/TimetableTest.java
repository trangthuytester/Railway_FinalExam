package testcases;

import dataobjects.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.BookTicketPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.TimetablePage;

import static common.constant.StationConstants.ARRIVE_STATION;
import static common.constant.StationConstants.DEPART_STATION;
import static common.constant.UserConstants.VALID_PASSWORD;
import static common.constant.UserConstants.VALID_USERNAME;

public class TimetableTest extends TestBase{

    @Test(description = "Open Book Ticket page from Timetable page")
    public void tc15_OpenBookTicketFromTimeTable_test() {
        SoftAssert soft = new SoftAssert();

        LoginPage loginPage = new LoginPage();
        User validUser = new User(VALID_USERNAME, VALID_PASSWORD);
        HomePage homePage = loginPage.loginAccount(validUser);

        soft.assertTrue(
                homePage.isWelcomeMessageDisplayed(validUser),
                "Welcome message is not displayed!");

        TimetablePage timetablePage = homePage.goToTimetablePage();
        BookTicketPage bookTicketPage = timetablePage.clickBookTicketLink(DEPART_STATION, ARRIVE_STATION);

        soft.assertTrue(
                bookTicketPage.isDepartAndArrive(DEPART_STATION, ARRIVE_STATION),
                "Depart From or Arrive At is not as expected!");

        soft.assertAll();
    }
}
