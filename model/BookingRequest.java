package eventsphere.model;

public final class BookingRequest {
    private final User user;
    private final Event event;
    private final Seat seat;
    private final String paymentMethod;

    public BookingRequest(User user, Event event, Seat seat, String paymentMethod) {
        this.user = user;
        this.event = event;
        this.seat = seat;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
