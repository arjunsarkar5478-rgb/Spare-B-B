package sparebnb;

public class Cabin extends Accommodation {

    private boolean hasFireplace;
    private double remoteSurcharge;

    public Cabin(int id, String title, String location, double pricePerNight, int maxGuests, User host, boolean hasFireplace, double remoteSurcharge) {
        super(id, title, location, pricePerNight, maxGuests, host);
        this.hasFireplace = hasFireplace;
        this.remoteSurcharge = remoteSurcharge;
    }

    @Override
    public double calculateTotal(int numberOfNights) {
        double subtotal = getPricePerNight() * numberOfNights;
        return subtotal + remoteSurcharge; // Polymorphism: Adds one-time remote surcharge
    }

    @Override
    public String printDetails() {
        String fireplace = hasFireplace ? "Yes" : "No";
        String hostName = super.postedBy != null ? super.postedBy.getFirstName() : "N/A";
        return String.format(
                "--- CABIN LISTING: %s ---\n" +
                        "  Location: %s\n" +
                        "  Fireplace: %s\n" +
                        "  Price: $%.2f / night\n" +
                        "  One-time Remote Surcharge: $%.2f\n" +
                        "  Host: %s\n" +
                        "  Facilities: %s\n",
                getTitle(), super.location, fireplace, getPricePerNight(), remoteSurcharge, hostName, getFacilityList()
        );
    }
}