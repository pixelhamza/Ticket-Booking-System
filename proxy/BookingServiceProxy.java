package eventsphere.proxy;

import eventsphere.model.BookingRequest;
import eventsphere.model.User;
import eventsphere.service.BookingService;

public final class BookingServiceProxy implements BookingService {
    private final BookingService realService;
    private final User currentUser;

    public BookingServiceProxy(BookingService realService, User currentUser) {
        this.realService = realService;
        this.currentUser = currentUser;
    }

    public void bookTicket(BookingRequest request) {
        if (!authenticate() || !authorize(request)) {
            throw new SecurityException("User is not authorized to make this booking.");
        }
        realService.bookTicket(request);
    }

    private boolean authenticate() {
        return currentUser != null && currentUser.isLoggedIn();
    }

    private boolean authorize(BookingRequest request) {
        return request != null && request.getUser() != null
                && currentUser.getUserId().equals(request.getUser().getUserId());
    }
}
