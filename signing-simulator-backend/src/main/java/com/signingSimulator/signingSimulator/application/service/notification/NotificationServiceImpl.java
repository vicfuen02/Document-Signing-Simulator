package com.signingSimulator.signingSimulator.application.service.notification;

import com.signingSimulator.signingSimulator.application.ports.input.notification.NotificationService;
import com.signingSimulator.signingSimulator.application.ports.input.notification.Sender;
import com.signingSimulator.signingSimulator.domain.Notification;
import com.signingSimulator.signingSimulator.domain.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.NotificationTypeEnum;
import com.signingSimulator.signingSimulator.domain.SentNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    private List<Sender> senders;
    private static final List<NotificationTypeEnum> types = List.of(NotificationTypeEnum.SMS, NotificationTypeEnum.EMAIL);


    @Autowired
    public NotificationServiceImpl(List<Sender> senders) {
        this.senders = senders;
    }

    @Override
    public SentNotification send(NotificationRequest notificationRequest) {

        List<Notification> notifications = new ArrayList<>();
        for (Sender sender: senders) {
            if (types.contains(sender.getType())) {
                notifications.addAll(sender.send(notificationRequest));
            }
        }

        SentNotification sentNotification = new SentNotification();
        sentNotification.setSentNotifications(notifications);

        return sentNotification;
    }
}
