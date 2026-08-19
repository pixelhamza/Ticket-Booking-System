package eventsphere.model;

public class Seat {
    private final String seatId;
    private final String seatType;
    private final double price;
    private boolean available = true;

    public Seat(String seatId, String seatType, double price) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.price = price;
    }

    public boolean reserve() {
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    public void cancel() {
        available = true;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}
