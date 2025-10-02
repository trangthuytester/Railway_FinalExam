package common.constant.enums;

import common.utility.JsonDataReader;

import java.util.Map;

public enum StationRoute {
    SAI_GON, PHAN_THIET, NHA_TRANG, DA_NANG, HUE, QUANG_NGAI;

    private static final JsonDataReader reader =
            new JsonDataReader("src/test/resources/data/stationRoutes.json");

    public String getDepart() {
        Map<String, Object> data = reader.getMap(this.name());
        return data.get("depart").toString();
    }

    public String[] getArrives() {
        Map<String, Object> data = reader.getMap(this.name());
        return ((java.util.List<String>) data.get("arrives")).toArray(new String[0]);
    }
}
