package eventsphere.chain;

import eventsphere.model.BookingRequest;

public abstract class BookingHandler {
    protected BookingHandler next;

    public BookingHandler setNext(BookingHandler handler) {
        next = handler;
        return handler;
    }

    public abstract void handle(BookingRequest request);

    protected void handleNext(BookingRequest request) {
        if (next != null) {
            next.handle(request);
        }
    }
}
