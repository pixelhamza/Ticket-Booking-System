package eventsphere.factory;

import eventsphere.model.CinemaSeat;
import eventsphere.model.Event;
import eventsphere.model.MovieEvent;
import eventsphere.model.MovieTicket;
import eventsphere.model.Seat;
import eventsphere.model.Ticket;

import java.time.LocalDate;

public final class MovieFactory implements EventFactory {
    public Event createEvent() {
        return new MovieEvent(1, "Midnight Premiere", LocalDate.now().plusDays(7), "Grand Cinema");
    }

    public Seat createSeat() {
        return new CinemaSeat("C-12", "Premium", 18.50);
    }

    public Ticket createTicket() {
        return new MovieTicket(18.50);
    }
}
