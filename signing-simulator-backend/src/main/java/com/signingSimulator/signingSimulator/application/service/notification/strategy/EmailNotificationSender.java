package com.signingSimulator.signingSimulator.application.service.notification.strategy;

import com.signingSimulator.signingSimulator.application.ports.input.notification.Sender;
import com.signingSimulator.signingSimulator.domain.notification.Notification;
import com.signingSimulator.signingSimulator.domain.notification.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.notification.NotificationTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailNotificationSender implements Sender {


    private static final Logger log = LogManager.getLogger(EmailNotificationSender.class);
    @Override
    public List<Notification> send(NotificationRequest notificationRequest) {


        List<Notification> notifications = new ArrayList<>();

        String msg = "Email notification: " + notificationRequest.getInfo();
        Notification notification = new Notification();
        notification.setMessage(msg);
        notification.setUserId(notification.getUserId());
        notification.setNotificationType(this.getType());

        notifications.add(notification);

        log.info("Notification sent to email: {}", notifications);

        return notifications;
    }

    @Override
    public NotificationTypeEnum getType() {
        return NotificationTypeEnum.EMAIL;
    }
}
