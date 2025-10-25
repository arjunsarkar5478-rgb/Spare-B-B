package sparebnb;

public class Flat extends Accommodation {

    private int numberOfBedrooms;
    private int floorLevel;

    public Flat(int id, String title, String location, double pricePerNight, int maxGuests, User host, int numberOfBedrooms, int floorLevel) {
        super(id, title, location, pricePerNight, maxGuests, host);
        this.numberOfBedrooms = numberOfBedrooms;
        this.floorLevel = floorLevel;
    }

    @Override
    public double calculateTotal(int numberOfNights) {
        return getPricePerNight() * numberOfNights;
    }

    @Override
    public String printDetails() {
        String hostName = super.postedBy != null ? super.postedBy.getFirstName() : "N/A";
        return String.format(
                "--- FLAT LISTING: %s ---\n" +
                        "  Location: %s (Floor: %d)\n" +
                        "  Bedrooms: %d\n" +
                        "  Price: $%.2f / night\n" +
                        "  Host: %s\n" +
                        "  Facilities: %s\n",
                getTitle(), super.location, floorLevel, numberOfBedrooms, getPricePerNight(), hostName, getFacilityList()
        );
    }
}