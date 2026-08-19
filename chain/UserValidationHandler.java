package eventsphere.chain;

import eventsphere.model.BookingRequest;

public final class UserValidationHandler extends BookingHandler {
    public void handle(BookingRequest request) {
        if (request.getUser() == null || !request.getUser().isLoggedIn()) {
            throw new IllegalStateException("A logged-in user is required to book a ticket.");
        }
        handleNext(request);
    }
}
