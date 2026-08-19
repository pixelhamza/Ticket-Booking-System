package eventsphere.bridge;
public final class EmailSender implements NotificationSender {
    public void send(String message) {
        System.out.println("  [Email] " + message);
    }
}
