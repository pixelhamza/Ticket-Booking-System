package eventsphere.chain;

import eventsphere.model.BookingRequest;
import eventsphere.singleton.BookingSystem;

public final class BookingConfirmationHandler extends BookingHandler {
    private final BookingSystem bookingSystem;

    public BookingConfirmationHandler(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }

    public void handle(BookingRequest request) {
        bookingSystem.createAndConfirmBooking(request);
    }
}
