package com.signingSimulator.signingSimulator.domain.exceptions;

public enum ServiceExceptionEnum {

    USER_NOT_FOUND ("LGI001", "The user does not exists"),
    WRONG_PASSWORD ("LGI002", "Wrong password"),

    CERTIFICATES_EMPTY ("CTR001", "The user has no certificates uploaded"),
    CERT_UPLOAD_ERROR ("CTR002", "Error uploading certificate"),
    CERT_EMPTY_PASSWORD ("CTR003  ", "Certificate password can not be empty"),
    WRONG_CERTIFICATE_PASSWORD ("SGN001", "Wrong certificate password")

    ;


    private String code;
    private String message;

    ServiceExceptionEnum(String code, String message) {
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
