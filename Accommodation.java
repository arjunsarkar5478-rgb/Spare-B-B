package sparebnb;

import java.util.ArrayList;
import java.util.List;

public abstract class Accommodation {

    private int id;
    private String title;
    protected String location;
    private double pricePerNight;
    private int maxGuests;
    protected User postedBy; // Aggregation
    private List<Facility> facilities; // Composition

    public Accommodation(int id, String title, String location, double pricePerNight, int maxGuests, User host) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.maxGuests = maxGuests;
        this.postedBy = host;
        this.status = AccommodationStatus.AVAILABLE;
        this.facilities = new ArrayList<>();
    }

    // Composition method
    public void addFacility(Facility facility) {
        this.facilities.add(facility);
    }

    // Getters
    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getTitle() {
        return title;
    }

    // Helper method to list facilities
    protected String getFacilityList() {
        StringBuilder sb = new StringBuilder();
        for (Facility f : facilities) {
            sb.append(f.getInfo()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "None";
    }

    // Abstraction & Polymorphism: Abstract methods
    public abstract double calculateTotal(int numberOfNights);
    public abstract String printDetails();
    // ... EXISTING FIELDS (id, title, location, etc.) ...

    // NEW FIELD: Uses the enum for status
    private AccommodationStatus status;

    // NEW METHODS: Getter and Setter for the status
    public AccommodationStatus getStatus() {
        return status;
    }

    public void setStatus(AccommodationStatus newStatus) {
        this.status = newStatus;
    }

    // ... (rest of the class code: addFacility, calculateTotal, printDetails, etc.)
}