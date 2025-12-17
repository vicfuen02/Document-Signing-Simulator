package com.signingSimulator.signingSimulator.domain.notification;

import com.signingSimulator.signingSimulator.domain.notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class SentNotification {


    private List<Notification> sentNotificationRequests = new ArrayList<>();


    public List<Notification> getSentNotifications() {
        return sentNotificationRequests;
    }

    public void setSentNotifications(List<Notification> sentNotificationRequests) {
        this.sentNotificationRequests = sentNotificationRequests;
    }

    @Override
    public String toString() {
        return "SentNotification{" +
                "sentNotificationRequests=" + sentNotificationRequests +
                '}';
    }
}
