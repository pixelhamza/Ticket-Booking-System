package eventsphere.observer;

public final class AnalyticsObserver implements BookingObserver {
    public void update(String message) {
        System.out.println("  [Analytics] " + message);
    }
}
