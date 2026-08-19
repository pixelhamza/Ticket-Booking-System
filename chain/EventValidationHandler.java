package eventsphere.chain;

import eventsphere.model.BookingRequest;

import java.time.LocalDate;

public final class EventValidationHandler extends BookingHandler {
    public void handle(BookingRequest request) {
        if (request.getEvent() == null || request.getEvent().getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The selected event is unavailable.");
        }
        handleNext(request);
    }
}
