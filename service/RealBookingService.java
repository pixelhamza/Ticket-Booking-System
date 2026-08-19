package eventsphere.service;

import eventsphere.chain.BookingConfirmationHandler;
import eventsphere.chain.BookingHandler;
import eventsphere.chain.EventValidationHandler;
import eventsphere.chain.PaymentHandler;
import eventsphere.chain.SeatAvailabilityHandler;
import eventsphere.chain.UserValidationHandler;
import eventsphere.model.BookingRequest;
import eventsphere.singleton.BookingSystem;

public final class RealBookingService implements BookingService {
    private final BookingSystem bookingSystem;

    public RealBookingService(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }

    public void bookTicket(BookingRequest request) {
        BookingHandler chain = new UserValidationHandler();
        chain.setNext(new EventValidationHandler())
                .setNext(new SeatAvailabilityHandler())
                .setNext(new PaymentHandler(bookingSystem.getPaymentService()))
                .setNext(new BookingConfirmationHandler(bookingSystem));
        chain.handle(request);
    }
}
