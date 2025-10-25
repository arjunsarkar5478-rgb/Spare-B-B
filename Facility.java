package sparebnb;

public class Facility {
    private String name;
    private String category;

    public Facility(String name, String category) {
        this.name = name;
        this.category = category;
    }

    // Public Getters for access
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    // User-friendly output helper
    public String getInfo() {
        return name + " (" + category + ")";
    }
}