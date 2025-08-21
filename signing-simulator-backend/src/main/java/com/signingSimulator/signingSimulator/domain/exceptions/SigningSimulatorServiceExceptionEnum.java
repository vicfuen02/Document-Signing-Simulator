package com.signingSimulator.signingSimulator.domain.exceptions;

public enum SigningSimulatorServiceExceptionEnum {

    USER_NOT_FOUND ("LGI001", "The user does not exists"),
    WRONG_PASSWORD ("LGI002", "Wrong password"),

    CERTIFICATES_EMPTY ("CTR001", "The user has no certificates uploaded"),
    CERT_UPLOAD_ERROR ("CTR002", "Error uploading certificate"),
    CERT_EMPTY_PASSWORD ("CTR003  ", "Certificate password can not be empty"),
    CERTIFICATES_NOT_FOUND ("CTR004", "Certification not found"),
    WRONG_CERTIFICATE_PASSWORD ("SGN001", "Wrong certificate password"),
    CERTIFICATE_INVALID ("SGN002", "Invalid certificate"),

    INVALID_DOCUMENT_TYPE("DOC001", "Invalid document type"),
    ERROR_POST_SIGNING("SGN003", "Error handling signing response"),

    NOTIFICATION_ADDRESS_NULL("NOT001", "Notification address can not be null"),

    KAFKA_PUBLISHER_ERROR("KFK001", "Error on kafka publisher"),

    KAFKA_CONSUMER_ERROR("KFK002", "Error on kafka consumer"),

    CONVERTING_PAYLOAD_ERROR("PYL001", "Error on kafka payload")

    ;


    private String code;
    private String message;

    SigningSimulatorServiceExceptionEnum(String code, String message) {
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
