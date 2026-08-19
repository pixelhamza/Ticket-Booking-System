package eventsphere.model;

import eventsphere.observer.BookingObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking {
    private final String bookingId;
    private final User user;
    private final Event event;
    private final Seat seat;
    private final Ticket ticket;
    private BookingStatus status;
    private final List<BookingObserver> observers = new ArrayList<>();

    public Booking(User user, Event event, Seat seat, Ticket ticket) {
        this.bookingId = UUID.randomUUID().toString();
        this.user = user;
        this.event = event;
        this.seat = seat;
        this.ticket = ticket;
        this.status = BookingStatus.CONFIRMED;
    }

    public void confirm() {
        status = BookingStatus.CONFIRMED;
        notifyObservers("Booking " + bookingId + " confirmed for " + event.getName());
    }

    public void cancel() {
        if (status == BookingStatus.CANCELLED) {
            return;
        }
        status = BookingStatus.CANCELLED;
        seat.cancel();
        notifyObservers("Booking " + bookingId + " cancelled");
    }

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }

    public String getBookingId() {
        return bookingId;
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

    public Ticket getTicket() {
        return ticket;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
