package com.signingSimulator.signingSimulator.application.ports.input.notification;

import com.signingSimulator.signingSimulator.domain.notification.Notification;
import com.signingSimulator.signingSimulator.domain.notification.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.notification.NotificationTypeEnum;

import java.util.List;

public interface Sender {

    List<Notification> send(NotificationRequest notificationRequest);

    NotificationTypeEnum getType();



}
