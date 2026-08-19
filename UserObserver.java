package eventsphere.observer;

import eventsphere.bridge.BookingNotification;
import eventsphere.bridge.EmailSender;
import eventsphere.bridge.Notification;
import eventsphere.model.User;

public final class UserObserver implements BookingObserver {
    private final User user;
    private final Notification notification;

    public UserObserver(User user) {
        this.user = user;
        this.notification = new BookingNotification(new EmailSender());
    }

    public void update(String message) {
        notification.notifyUser("To " + user.getEmail() + " | " + message);
    }
}
