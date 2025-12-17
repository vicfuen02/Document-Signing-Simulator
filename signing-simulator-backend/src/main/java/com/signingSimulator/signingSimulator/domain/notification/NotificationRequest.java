package com.signingSimulator.signingSimulator.domain.notification;

import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;

public class NotificationRequest {


    private Long userId;
    private String info;

    private NotificationRequest(NotificationRequest.Builder notificationRequest) {
        this.userId = notificationRequest.userId;
        this.info = notificationRequest.info;
    }

    public Long getUserId() {
        return userId;
    }

    public String getInfo() {
        return info;
    }



    public static class Builder {

        private Long userId;
        private String info;

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setInfo(String info) {
            this.info = info;
            return this;
        }

        public NotificationRequest build() {
            if (userId == null) {
                throw new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.NOTIFICATION_ADDRESS_NULL);
            }
            return new NotificationRequest(this);
        }

    }



}
