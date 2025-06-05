package com.signingSimulator.signingSimulator.application.service.notification.strategy;

import com.signingSimulator.signingSimulator.application.ports.input.notification.Sender;
import com.signingSimulator.signingSimulator.domain.Notification;
import com.signingSimulator.signingSimulator.domain.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.NotificationTypeEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SmsNotificationSender implements Sender {



    @Override
    public List<Notification> send(NotificationRequest notificationRequest) {

        List<Notification> notifications = new ArrayList<>();

        String msg = "Sms notification: " + notificationRequest.getInfo();
        Notification notification = new Notification();
        notification.setMessage(msg);
        notification.setUserId(notification.getUserId());
        notification.setNotificationType(this.getType());

        notifications.add(notification);

        return notifications;
    }


    @Override
    public NotificationTypeEnum getType() {
        return NotificationTypeEnum.SMS;
    }


}
