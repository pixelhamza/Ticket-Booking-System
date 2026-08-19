package eventsphere.observer;

import eventsphere.bridge.Notification;
import eventsphere.bridge.PaymentNotification;
import eventsphere.bridge.PushSender;

public final class AdminObserver implements BookingObserver {
    private final Notification notification = new PaymentNotification(new PushSender());

    public void update(String message) {
        notification.notifyUser("Admin alert | " + message);
    }
}
