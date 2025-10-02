package common.constant.enums;

import common.utility.JsonDataReader;

public enum SeatType {
    HARD_SEAT("HARD_SEAT"),
    SOFT_SEAT("SOFT_SEAT"),
    SOFT_SEAT_AC("SOFT_SEAT_AC"),
    HARD_BED("HARD_BED"),
    SOFT_BED("SOFT_BED"),
    SOFT_BED_AC("SOFT_BED_AC");

    private static final JsonDataReader reader =
            new JsonDataReader("src/test/resources/data/seatTypes.json");

    private final String key;

    SeatType(String key) {
        this.key = key;
    }

    public String getDisplayName() {
        return reader.getString(key);
    }
}
