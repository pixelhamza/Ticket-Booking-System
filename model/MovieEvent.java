package eventsphere.model;

import java.time.LocalDate;

public final class MovieEvent extends Event {
    public MovieEvent(int eventId, String name, LocalDate date, String venue) {
        super(eventId, name, EventType.MOVIE, date, venue);
    }
}
