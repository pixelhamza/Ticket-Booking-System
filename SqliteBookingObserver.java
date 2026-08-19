package eventsphere.observer;

import eventsphere.database.BookingEventRepository;
import eventsphere.model.Booking;

public final class SqliteBookingObserver implements BookingObserver {
    private final Booking booking;
    private final BookingEventRepository repository;

    public SqliteBookingObserver(Booking booking, BookingEventRepository repository) {
        this.booking = booking;
        this.repository = repository;
    }

    public void update(String message) {
        repository.save(booking, message);
        System.out.println("  [SQLite] Booking event saved");
    }
}
