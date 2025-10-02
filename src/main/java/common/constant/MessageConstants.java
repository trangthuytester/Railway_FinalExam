package common.constant;

import common.utility.TestDataConfig;

public class MessageConstants {
    public static final String BLANK_OR_INVALID_ERRORMESSAGE =
            TestDataConfig.getString("messages", "BLANK_OR_INVALID_ERRORMESSAGE");
    public static final String SEVERAL_TIME_INVALID_ERRORMESSAGE =
            TestDataConfig.getString("messages", "SEVERAL_TIME_INVALID_ERRORMESSAGE");
    public static final String INACTIVATED_ACCOUNT_ERRORMESSAGE =
            TestDataConfig.getString("messages", "INACTIVATED_ACCOUNT_ERRORMESSAGE");
    public static final String CHANGEPASSWORD_SUCCESSFULLYMESSAGE =
            TestDataConfig.getString("messages", "CHANGEPASSWORD_SUCCESSFULLYMESSAGE");
    public static final String REGISTERWITH_INVALIDCONFIRMPASSWORD_ERRORMESSAGE =
            TestDataConfig.getString("messages", "REGISTERWITH_INVALIDCONFIRMPASSWORD_ERRORMESSAGE");
    public static final String REGISTERWITH_BLANKPASSWORD_ERRORMESSAGE =
            TestDataConfig.getString("messages", "REGISTERWITH_BLANKPASSWORD_ERRORMESSAGE");
    public static final String REGISTERWITH_BLANKPID_ERRORMESSAGE =
            TestDataConfig.getString("messages", "REGISTERWITH_BLANKPID_ERRORMESSAGE");
    public static final String RESETPASSWORDWITH_BLANKRESETPASSWORD_ERRORMESSAGE_1 =
            TestDataConfig.getString("messages", "RESETPASSWORDWITH_BLANKRESETPASSWORD_ERRORMESSAGE_1");
    public static final String RESETPASSWORDWITH_BLANKRESETPASSWORD_ERRORMESSAGE_2 =
            TestDataConfig.getString("messages", "RESETPASSWORDWITH_BLANKRESETPASSWORD_ERRORMESSAGE_2");
    public static final String RESETPASSWORDWITH_PASSWORDCONFIRMPASSWORDNOTMATCH_ERRORMESSAGE_1 =
            TestDataConfig.getString("messages", "RESETPASSWORDWITH_PASSWORDCONFIRMPASSWORDNOTMATCH_ERRORMESSAGE_1");
    public static final String RESETPASSWORDWITH_PASSWORDCONFIRMPASSWORDNOTMATCH_ERRORMESSAGE_2 =
            TestDataConfig.getString("messages", "RESETPASSWORDWITH_PASSWORDCONFIRMPASSWORDNOTMATCH_ERRORMESSAGE_2");
    public static final String INSTRUCTION_MESSAGE =
            TestDataConfig.getString("messages", "INSTRUCTION_MESSAGE");
    public static final String RESETPASSWORD_MAIL =
            TestDataConfig.getString("messages", "RESETPASSWORD_MAIL");
    public static final String REGISTER_SUCCESS_MESSAGE =
            TestDataConfig.getString("messages", "REGISTER_SUCCESS_MESSAGE");
    public static final String NOTICKETERRORMESSAGE =
            TestDataConfig.getString("messages", "NOTICKETERRORMESSAGE");
    public static final String CURRENTTICKETMESSAGE =
            TestDataConfig.getString("messages", "CURRENTTICKETMESSAGE");
}
