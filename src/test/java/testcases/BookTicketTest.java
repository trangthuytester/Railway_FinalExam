package testcases;
import dataobjects.Ticket;
import dataobjects.User;
import helpers.TestHelper;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.BookTicketPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;

import java.util.*;

import static common.constant.StationConstants.*;
import static common.constant.UserConstants.VALID_PASSWORD;
import static common.constant.UserConstants.VALID_USERNAME;

public class BookTicketTest extends TestBase{
    @Test (description = "Book multiple ticket and filter successfully ")
    public void tc_BookMultipleTicket_test() {
        SoftAssert soft = new SoftAssert();

        LoginPage loginPage = new LoginPage();
        User validUser = new User(VALID_USERNAME, VALID_PASSWORD);
        HomePage homePage = loginPage.loginAccount(validUser);

        BookTicketPage bookTicketPage = homePage.goToBookTicketPage();

        List<Ticket> bookedTickets = TestHelper.bookMultipleTickets(MULTIPLE_TICKET, bookTicketPage);

        MyTicketPage myTicketPage = bookTicketPage.goToMyTicketPage();

        Ticket randomTicket = bookedTickets.get(new Random().nextInt(bookedTickets.size()));

        String filterDate = randomTicket.getFormattedDepartDate();

        myTicketPage.filterTicketByDepartDate(filterDate);
        myTicketPage.assertFilterMatches(randomTicket, filterDate, soft);

        soft.assertAll();
    }
}
