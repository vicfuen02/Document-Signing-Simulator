package com.signingSimulator.signingSimulator.application.ports.input.notification;

import com.signingSimulator.signingSimulator.domain.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.SentNotification;

public interface NotificationService {

    SentNotification send(NotificationRequest notificationRequest);

}
