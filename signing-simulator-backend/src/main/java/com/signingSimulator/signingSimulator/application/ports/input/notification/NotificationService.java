package com.signingSimulator.signingSimulator.application.ports.input.notification;

import com.signingSimulator.signingSimulator.domain.notification.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.notification.SentNotification;

public interface NotificationService {

    SentNotification send(NotificationRequest notificationRequest);

}
