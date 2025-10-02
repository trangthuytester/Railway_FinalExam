package common.constant;

import common.utility.TestDataConfig;

public class UserConstants {
    public static final String VALID_USERNAME = TestDataConfig.getString("user", "VALID_USERNAME");
    public static final String VALID_USERNAME_2 = TestDataConfig.getString("user", "VALID_USERNAME_2");
    public static final String VALID_MAIL = TestDataConfig.getString("user", "VALID_MAIL");
    public static final String VALID_PASSWORD = TestDataConfig.getString("user", "VALID_PASSWORD");
    public static final String VALID_PASSWORD_2 = TestDataConfig.getString("user", "VALID_PASSWORD_2");
    public static final String INVALID_PASSWORD = TestDataConfig.getString("user", "INVALID_PASSWORD");
    public static final String BLANK_USERNAME = TestDataConfig.getString("user", "BLANK_USERNAME");

    public static final String VALID_EMAIL_REGISTER = TestDataConfig.getString("user", "VALID_EMAIL_REGISTER");
    public static final String VALID_PASSWORD_REGISTER = TestDataConfig.getString("user", "VALID_PASSWORD_REGISTER");
    public static final String VALID_CONFIRM_PASSWORD_REGISTER = TestDataConfig.getString("user", "VALID_CONFIRM_PASSWORD_REGISTER");
    public static final String VALID_PID_REGISTER = TestDataConfig.getString("user", "VALID_PID_REGISTER");

    public static final String VALID_USERNAME_CHANGEPASSWORD = TestDataConfig.getString("user", "VALID_USERNAME_CHANGEPASSWORD");
    public static final String VALID_CURRENTPASSWORD_CHANGEPASSWORD = TestDataConfig.getString("user", "VALID_CURRENTPASSWORD_CHANGEPASSWORD");
    public static final String VALID_NEWPASSWORD_CHANGEPASSWORD = TestDataConfig.getString("user", "VALID_NEWPASSWORD_CHANGEPASSWORD");

    public static final String INACTIVATED_USERNAME = TestDataConfig.getString("user", "INACTIVATED_USERNAME");
    public static final String INACTIVATED_PASSWORD = TestDataConfig.getString("user", "INACTIVATED_PASSWORD");
    public static final String INVALID_CONFIRM_PASSWORD_REGISTER = TestDataConfig.getString("user", "INVALID_CONFIRM_PASSWORD_REGISTER");
    public static final int INVALID_LOGIN_ATTEMPTS = TestDataConfig.getInt("user", "INVALID_LOGIN_ATTEMPTS");

    public static final String BLANK_PASSWORD_REGISTER = TestDataConfig.getString("user", "BLANK_PASSWORD_REGISTER");
    public static final String BLANK_CONFIRM_PASSWORD_REGISTER = TestDataConfig.getString("user", "BLANK_CONFIRM_PASSWORD_REGISTER");
    public static final String BLANK_PID_REGISTER = TestDataConfig.getString("user", "BLANK_PID_REGISTER");

    public static final String VALID_NAME = TestDataConfig.getString("user", "VALID_NAME");
    public static final String VALID_DOMAIN = TestDataConfig.getString("user", "VALID_DOMAIN");
}
