package com.signingSimulator.signingSimulator.common.interceptors;

public enum RestControllerExceptionEnum {


    USER_NOT_LOGGED ("RLG001", "User is not logged")


    ;

    private String code;
    private String message;


    RestControllerExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
