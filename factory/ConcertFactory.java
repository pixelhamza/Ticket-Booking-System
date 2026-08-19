package eventsphere.factory;

import eventsphere.model.ConcertEvent;
import eventsphere.model.ConcertSeat;
import eventsphere.model.ConcertTicket;
import eventsphere.model.Event;
import eventsphere.model.Seat;
import eventsphere.model.Ticket;

import java.time.LocalDate;

public final class ConcertFactory implements EventFactory {
    public Event createEvent() {
        return new ConcertEvent(2, "Summer Live", LocalDate.now().plusDays(14), "City Arena");
    }

    public Seat createSeat() {
        return new ConcertSeat("A-08", "Floor", 75.00);
    }

    public Ticket createTicket() {
        return new ConcertTicket(75.00);
    }
}
