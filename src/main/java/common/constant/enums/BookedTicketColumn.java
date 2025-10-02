package common.constant.enums;

import common.utility.JsonDataReader;

public enum BookedTicketColumn {
    DEPART,
    ARRIVE,
    SEAT_TYPE,
    DEPART_DATE,
    AMOUNT;

    private static final JsonDataReader reader =
            new JsonDataReader("src/test/resources/data/bookedTicketColumns.json");

    public int getIndex() {
        return reader.getInt(this.name());
    }

    public String getHeaderText() {
        return reader.getString(this.name());
    }
}
