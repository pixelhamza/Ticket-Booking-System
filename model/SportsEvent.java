package eventsphere.model;

import java.time.LocalDate;

public final class SportsEvent extends Event {
    public SportsEvent(int eventId, String name, LocalDate date, String venue) {
        super(eventId, name, EventType.SPORTS, date, venue);
    }
}
