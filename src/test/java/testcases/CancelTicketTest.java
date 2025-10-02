package testcases;

import common.constant.enums.SeatType;
import common.constant.enums.StationRoute;
import dataobjects.Ticket;
import dataobjects.User;
import helpers.TestHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.BookTicketPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;

import java.util.List;

import static common.constant.StationConstants.*;
import static common.constant.UserConstants.VALID_PASSWORD_2;
import static common.constant.UserConstants.VALID_USERNAME_2;

public class CancelTicketTest extends TestBase{

    @Test(description = "Cancel multiple tickets successfully")
    public void tc_CancelMultipleTickets_test() {
        SoftAssert soft = new SoftAssert();

        LoginPage loginPage = new LoginPage();
        User validUser = new User(VALID_USERNAME_2, VALID_PASSWORD_2);
        HomePage homePage = loginPage.loginAccount(validUser);
        soft.assertTrue(homePage.isWelcomeMessageDisplayed(validUser),
                "Welcome message is not displayed!");

        BookTicketPage bookTicketPage = homePage.goToBookTicketPage();
        List<Ticket> bookedTickets = TestHelper.bookMultipleTickets(6, bookTicketPage);


        MyTicketPage myTicketPage = homePage.goToMyTicketPage();

        TestHelper.cancelMultipleTickets(bookedTickets, myTicketPage, soft);
        Assert.assertTrue(
                myTicketPage.isErrorMessageDisplayedWithNoTicket(),
                "Error message is not displayed!");
        Assert.assertTrue(
                myTicketPage.isCurrentTicketMessageDisplayedWithNoTicket(),
                "Current ticket message is not displayed!");
        soft.assertAll();
    }

}
