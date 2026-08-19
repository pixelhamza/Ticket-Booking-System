package eventsphere.singleton;

import eventsphere.model.Booking;
import eventsphere.model.BookingRequest;
import eventsphere.model.ConcertTicket;
import eventsphere.model.MovieTicket;
import eventsphere.model.SportsTicket;
import eventsphere.model.Ticket;
import eventsphere.observer.AdminObserver;
import eventsphere.observer.AnalyticsObserver;
import eventsphere.observer.UserObserver;
import eventsphere.service.BookingService;
import eventsphere.service.PaymentService;
import eventsphere.service.RealBookingService;

import java.util.ArrayList;
import java.util.List;

public final class BookingSystem {
    private static final BookingSystem INSTANCE = new BookingSystem();

    private final BookingService bookingService;
    private final PaymentService paymentService;
    private final List<Booking> bookings = new ArrayList<>();

    private BookingSystem() {
        paymentService = new PaymentService();
        bookingService = new RealBookingService(this);
    }

    public static BookingSystem getInstance() {
        return INSTANCE;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public Booking getLatestBooking() {
        if (bookings.isEmpty()) {
            return null;
        }
        return bookings.getLast();
    }

    public Booking createAndConfirmBooking(BookingRequest request) {
        Ticket ticket = switch (request.getEvent().getType()) {
            case MOVIE -> new MovieTicket(request.getSeat().getPrice());
            case CONCERT -> new ConcertTicket(request.getSeat().getPrice());
            case SPORTS -> new SportsTicket(request.getSeat().getPrice());
        };
        Booking booking = new Booking(request.getUser(), request.getEvent(), request.getSeat(), ticket);
        booking.addObserver(new UserObserver(request.getUser()));
        booking.addObserver(new AdminObserver());
        booking.addObserver(new AnalyticsObserver());
        bookings.add(booking);
        paymentService.recordPayment(booking.getBookingId());
        booking.confirm();
        return booking;
    }
}
