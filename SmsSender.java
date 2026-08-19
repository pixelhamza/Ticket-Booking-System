package eventsphere.bridge;
public final class SMSSender implements NotificationSender {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
