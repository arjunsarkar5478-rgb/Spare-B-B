package sparebnb;

import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(int bookingId, LocalDate startDate, LocalDate endDate) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}