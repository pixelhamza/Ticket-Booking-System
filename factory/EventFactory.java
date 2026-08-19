package eventsphere.factory;

import eventsphere.model.Event;
import eventsphere.model.Seat;
import eventsphere.model.Ticket;

public interface EventFactory {
    Event createEvent();
    Seat createSeat();
    Ticket createTicket();
}
