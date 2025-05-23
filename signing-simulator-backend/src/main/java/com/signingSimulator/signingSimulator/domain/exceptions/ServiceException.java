package com.signingSimulator.signingSimulator.domain.exceptions;

public class ServiceException extends Exception {

    private String code;
    private String message;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message, String code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public ServiceException(String message, Throwable cause, String code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public ServiceException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
