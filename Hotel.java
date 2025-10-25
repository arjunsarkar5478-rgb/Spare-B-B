package sparebnb;

public class Hotel extends Accommodation {

    private int starRating;
    private boolean includesBreakfast;
    private final double serviceFeePercentage = 0.15;

    public Hotel(int id, String title, String location, double pricePerNight, int maxGuests, User host, int starRating, boolean includesBreakfast) {
        super(id, title, location, pricePerNight, maxGuests, host);
        this.starRating = starRating;
        this.includesBreakfast = includesBreakfast;
    }

    @Override
    public double calculateTotal(int numberOfNights) {
        double subtotal = getPricePerNight() * numberOfNights;
        return subtotal * (1 + serviceFeePercentage); // Polymorphism: Adds service fee
    }

    @Override
    public String printDetails() {
        String breakfast = includesBreakfast ? "YES" : "NO";
        String hostName = super.postedBy != null ? super.postedBy.getFirstName() : "N/A";
        return String.format(
                "--- HOTEL LISTING: %s ---\n" +
                        "  Location: %s\n" +
                        "  Rating: %d-Star\n" +
                        "  Includes Breakfast: %s\n" +
                        "  Price: $%.2f / night (excl. %.0f%% service fee)\n" +
                        "  Host: %s\n" +
                        "  Facilities: %s\n",
                getTitle(), super.location, starRating, breakfast, getPricePerNight(), serviceFeePercentage * 100, hostName, getFacilityList()
        );
    }
}