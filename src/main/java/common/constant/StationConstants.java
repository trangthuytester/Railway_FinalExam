package common.constant;

import common.utility.TestDataConfig;

public class StationConstants {
    public static final int TICKET_AMOUNT = TestDataConfig.getInt("station", "ticketAmount");
    public static final int MULTIPLE_TICKET = TestDataConfig.getInt("station", "multipleTicket");
}
