package eventsphere.model;

import java.time.LocalDate;

public final class ConcertEvent extends Event {
    public ConcertEvent(int eventId, String name, LocalDate date, String venue) {
        super(eventId, name, EventType.CONCERT, date, venue);
    }
}
