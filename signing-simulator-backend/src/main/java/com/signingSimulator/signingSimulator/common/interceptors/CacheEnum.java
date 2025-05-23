package com.signingSimulator.signingSimulator.common.interceptors;

public enum CacheEnum {


    LOGGED_USERS("X-User-LOGGED_USERS")

    ;

    private String code;

    CacheEnum(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }
}
