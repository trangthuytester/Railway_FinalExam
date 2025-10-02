package common.constant;

import common.utility.TestDataConfig;

public class StationConstants {
    public static final String DEPART_STATION = TestDataConfig.getString("station", "departStation");
    public static final String ARRIVE_STATION = TestDataConfig.getString("station", "arriveStation");
    public static final int BOOK_TICKET_DAY = TestDataConfig.getInt("station", "daysToAdd");
    public static final int TICKET_AMOUNT = TestDataConfig.getInt("station", "ticketAmount");
    public static final int MULTIPLE_TICKET = TestDataConfig.getInt("station", "multipleTicket");
}
