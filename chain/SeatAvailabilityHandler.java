package eventsphere.chain;

import eventsphere.model.BookingRequest;

public final class SeatAvailabilityHandler extends BookingHandler {
    public void handle(BookingRequest request) {
        if (request.getSeat() == null || !request.getSeat().reserve()) {
            throw new IllegalStateException("The selected seat is no longer available.");
        }
        handleNext(request);
    }
}
