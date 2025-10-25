package sparebnb;

public class LuxuryVilla extends Accommodation {

    private boolean privatePool;
    private double cleaningFee;

    public LuxuryVilla(int id, String title, String location, double pricePerNight, int maxGuests, User host, boolean privatePool, double cleaningFee) {
        super(id, title, location, pricePerNight, maxGuests, host);
        this.privatePool = privatePool;
        this.cleaningFee = cleaningFee;
    }

    @Override
    public double calculateTotal(int numberOfNights) {
        double subtotal = getPricePerNight() * numberOfNights;
        return subtotal + cleaningFee; // Polymorphism: Adds one-time cleaning fee
    }

    @Override
    public String printDetails() {
        String poolStatus = privatePool ? "Private Pool Included" : "No Private Pool";
        String hostName = super.postedBy != null ? super.postedBy.getFirstName() : "N/A";
        return String.format(
                "--- LUXURY VILLA LISTING: %s ---\n" +
                        "  Location: %s\n" +
                        "  Features: %s\n" +
                        "  Price: $%.2f / night\n" +
                        "  One-time Cleaning Fee: $%.2f\n" +
                        "  Host: %s\n" +
                        "  Facilities: %s\n",
                getTitle(), super.location, poolStatus, getPricePerNight(), cleaningFee, hostName, getFacilityList()
        );
    }
}