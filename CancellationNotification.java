package eventsphere.bridge;
public final class CancellationNotification extends Notification {
    public CancellationNotification(NotificationSender sender) {
        super(sender);
    }
    public void notifyUser(String message) {
        sender.send("Cancellation update: " + message);
    }
}
