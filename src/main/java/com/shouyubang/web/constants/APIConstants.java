package com.shouyubang.web.constants;


public class APIConstants {
    public final static String APP_ID = "wxe3d0920a2875ac4d";
    public final static String PARTNER = "1488431672";
    public final static String PARTNER_KEY = "BFFE28C8B7FE87D04870FC1D626296BA";
    public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public final static String WEI_XIN_NOTIFY_URL = "http://www.shouyubang.com:8080/guanli/api/pay/wxpay/notify";    //修改tomcat上传包名，同时修改guanli

    public final static int QUESTION_OPEN = 0;
    public final static int QUESTION_TO_SOLVE = 1;
    public final static int QUESTION_CLOSED = 2;

    public final static int VERIFY_NOT_ADDED = 0;
    public final static int VERIFY_UNDER_REVIEW = 1;
    public final static int VERIFY_NOT_PASS = 2;
    public final static int VERIFY_PASSED = 3;

    public final static int PAY_NO = 0;
    public final static int PAY_FINISH = 1;

    public final static int PRICE_RATIO = 1;
}
