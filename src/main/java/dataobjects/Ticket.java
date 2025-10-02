package dataobjects;

import common.constant.enums.SeatType;
import common.constant.enums.StationRoute;
import common.utility.DateUtils;

public class Ticket {
    private int daysToAdd;
    private StationRoute departStation;
    private StationRoute arriveStation;
    private SeatType seatType;
    private int ticketAmount;
    private String ticketId;

    public Ticket(int daysToAdd, StationRoute departStation, StationRoute arriveStation,
                  SeatType seatType, int ticketAmount) {
        this.daysToAdd = daysToAdd;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public StationRoute getDepartStation() {
        return departStation;
    }

    public StationRoute getArriveStation() {
        return arriveStation;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getDaysToAdd() {
        return daysToAdd;
    }

    public String getFormattedDepartDate() {
        return DateUtils.getFormattedDate(daysToAdd, "M/d/yyyy");
    }

}

