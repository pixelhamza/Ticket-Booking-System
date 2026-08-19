package eventsphere.bridge
public abstract class Notification {
    protected final NotificationSender sender;
    protected Notification(NotificationSender sender) {
        this.sender = sender;
    }
    public abstract void notifyUser(String message);
}
