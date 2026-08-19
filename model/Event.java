package eventsphere.model;

import java.time.LocalDate;

public class Event {
    private final int eventId;
    private final String name;
    private final EventType type;
    private final LocalDate date;
    private final String venue;

    public Event(int eventId, String name, EventType type, LocalDate date, String venue) {
        this.eventId = eventId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.venue = venue;
    }

    public String getDetails() {
        return "%s at %s on %s".formatted(name, venue, date);
    }

    public int getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public EventType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }
}
