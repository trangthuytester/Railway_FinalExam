package helpers;

import common.constant.enums.SeatType;
import common.constant.enums.StationRoute;
import common.utility.DateUtils;
import dataobjects.Ticket;
import org.testng.asserts.SoftAssert;
import pageobjects.BookTicketPage;
import pageobjects.MyTicketPage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static common.constant.StationConstants.TICKET_AMOUNT;

public class TestHelper {

    public static List<Ticket> bookMultipleTickets(
            int numberOfTickets,
            BookTicketPage bookTicketPage
    ) {
        Set<Integer> usedDays = new HashSet<>();
        List<Ticket> bookedTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            int randomDay = DateUtils.getRandomUniqueDay(usedDays);

            Ticket ticket = new Ticket(
                    randomDay,
                    StationRoute.SAI_GON,
                    StationRoute.NHA_TRANG,
                    SeatType.SOFT_BED_AC,
                    TICKET_AMOUNT
            );

            bookTicketPage.bookTicket(ticket);

            String ticketId = bookTicketPage.getTicketIdFromSuccessUrl();
            ticket.setTicketId(ticketId);

            bookedTickets.add(ticket);
        }

        return bookedTickets;
    }


    public static void cancelMultipleTickets(
            List<Ticket> bookedTickets,
            MyTicketPage myTicketPage,
            SoftAssert soft
    ) {
        List<String> ticketIds = bookedTickets.stream()
                .map(Ticket::getTicketId)
                .collect(Collectors.toList());

        for (String ticketId : ticketIds) {
            try {
                myTicketPage.cancelTicketById(ticketId);
                soft.assertTrue(
                        myTicketPage.isTicketCancelled(ticketId),
                        "❌ The canceled ticket with ID " + ticketId + " should disappear but still exists."
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
