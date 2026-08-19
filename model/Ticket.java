package eventsphere.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final double price;
    private final LocalDateTime issueDate;

    public Ticket(double price) {
        this.ticketId = UUID.randomUUID().toString();
        this.price = price;
        this.issueDate = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }
}
