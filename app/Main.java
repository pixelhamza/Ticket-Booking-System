package eventsphere.app;

import eventsphere.factory.EventFactory;
import eventsphere.factory.MovieFactory;
import eventsphere.model.Booking;
import eventsphere.model.BookingRequest;
import eventsphere.model.Event;
import eventsphere.model.Seat;
import eventsphere.model.User;
import eventsphere.proxy.BookingServiceProxy;
import eventsphere.service.BookingService;
import eventsphere.singleton.BookingSystem;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       EVENTSPHERE TICKET BOOKING");
        System.out.println("========================================");

        User user = new User("user-101", "Ava Patel", "ava@example.com", "secure-password");
        if (!user.login("secure-password")) {
            throw new IllegalStateException("Login failed.");
        }

        EventFactory factory = new MovieFactory();
        Event event = factory.createEvent();
        Seat seat = factory.createSeat();
        BookingRequest request = new BookingRequest(user, event, seat, "Credit Card");

        System.out.println("\nBooking Request");
        System.out.println("----------------------------------------");
        System.out.printf("Customer : %s%n", user.getName());
        System.out.printf("Event    : %s%n", event.getDetails());
        System.out.printf("Seat     : %s (%s)%n", seat.getSeatId(), seat.getSeatType());
        System.out.printf("Price    : $%.2f%n", seat.getPrice());
        System.out.printf("Payment  : %s%n", request.getPaymentMethod());

        BookingSystem system = BookingSystem.getInstance();
        BookingService service = new BookingServiceProxy(system.getBookingService(), user);
        System.out.println("\nNotifications");
        System.out.println("----------------------------------------");
        service.bookTicket(request);

        Booking booking = system.getLatestBooking();
        System.out.println("\nBooking Confirmed");
        System.out.println("----------------------------------------");
        System.out.printf("Booking ID : %s%n", booking.getBookingId());
        System.out.printf("Ticket ID  : %s%n", booking.getTicket().getTicketId());
        System.out.printf("Status     : %s%n", booking.getStatus());
        System.out.println("========================================");
    }
}
