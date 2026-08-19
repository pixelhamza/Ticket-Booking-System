package eventsphere.factory;

import eventsphere.model.Event;
import eventsphere.model.Seat;
import eventsphere.model.SportsEvent;
import eventsphere.model.SportsTicket;
import eventsphere.model.StadiumSeat;
import eventsphere.model.Ticket;

import java.time.LocalDate;

public final class SportsFactory implements EventFactory {
    public Event createEvent() {
        return new SportsEvent(3, "Championship Final", LocalDate.now().plusDays(21), "National Stadium");
    }

    public Seat createSeat() {
        return new StadiumSeat("S-101", "Lower Tier", 55.00);
    }

    public Ticket createTicket() {
        return new SportsTicket(55.00);
    }
}
