package common.constant;

import common.utility.TestDataConfig;

public class GlobalConstants {
    public static final String BASE_URL = TestDataConfig.getString("global", "baseUrl");
    public static final String MAIL_URL = TestDataConfig.getString("global", "mailUrl");
    public static final String PASSWORD_RESET_URL = TestDataConfig.getString("global", "passwordResetUrl");
}
