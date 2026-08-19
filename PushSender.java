package eventsphere.bridge;
public final class PushSender implements NotificationSender {
    public void send(String message) {
        System.out.println("  [Push] " + message);
    }
}
