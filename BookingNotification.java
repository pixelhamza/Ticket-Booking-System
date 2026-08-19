package eventsphere.bridge;
public final class BookingNotification extends Notification {
    public BookingNotification(NotificationSender sender) {
        super(sender);
    }
    public void notifyUser(String message) {
        sender.send("Booking update: " + message);
    }
}