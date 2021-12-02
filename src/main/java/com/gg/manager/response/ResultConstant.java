package com.gg.manager.response;

public class ResultConstant {
    public static final int STATUS_OK = 0;
    public static final int STATUS_DEFAULT_ERROR = 100;
    public static final int STATUS_TOKEN_ERROR = 101;
    public static final int STATUS_TOKEN_EXPIRED = 102;

    public static final String DEFAULT_EXCEPTION = "server error";
    public static final String TOKEN_ERROR_EXCEPTION = "Invalid token";
    public static final String TOKEN_EXPIRED_EXCEPTION = "Token timeout";

}
