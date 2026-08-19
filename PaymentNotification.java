package eventsphere.bridge;
public final class PaymentNotification extends Notification {
    public PaymentNotification(NotificationSender sender) {
        super(sender);
    }
    public void notifyUser(String message) {
        sender.send("Payment update: " + message);
    }
}
