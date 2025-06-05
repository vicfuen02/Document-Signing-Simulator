package com.signingSimulator.signingSimulator.application.ports.input.notification;

import com.signingSimulator.signingSimulator.domain.Notification;
import com.signingSimulator.signingSimulator.domain.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.NotificationTypeEnum;

import java.util.List;

public interface Sender {

    List<Notification> send(NotificationRequest notificationRequest);

    NotificationTypeEnum getType();



}
