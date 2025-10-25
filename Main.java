package sparebnb;

public class Main {
    public static void main(String[] args) {

        // 1. Create Host Users (Aggregation)
        User hostA = new User(101, "Arjun", "arj@host.com");
        User hostB = new User(102, "Liza", "liza@host.com");
        User hostC = new User(102, "Josh", "josh@host.com");
        User hostD = new User(102, "Priya", "priya@host.com");

        // 2. Create Facility Objects (Composition)
        Facility wifi = new Facility("High-Speed Wi-Fi", "Connectivity");
        Facility kitchen = new Facility("Full Kitchen", "Cooking");
        Facility pool = new Facility("Swimming Pool", "Leisure");

        // --- OBJECT 1: FLAT ---
        Flat gulshanFlat = new Flat(
                1, "Modern Glory Flat", "Gulshan 1, Dhaka", 85.50, 4, hostA, 2, 5
        );
        gulshanFlat.addFacility(wifi); // Composition in action
        gulshanFlat.addFacility(kitchen);


        // --- OBJECT 2: HOTEL ---
        Hotel coxHotel = new Hotel(
                2, "Sea View Grand Hotel", "Cox's Bazar", 120.00, 2, hostD, 4, true
        );
        coxHotel.addFacility(pool);
        coxHotel.addFacility(wifi);


        // --- OBJECT 3: LUXURY VILLA ---
        LuxuryVilla srimongolVilla = new LuxuryVilla(
                3, "Tea Garden Retreat Villa", "Srimongol, Sylhet", 250.00, 8, hostC, true, 50.00
        );
        srimongolVilla.addFacility(new Facility("Sauna", "Wellness"));


        // --- OBJECT 4: CABIN ---
        Cabin sundarbanCabin = new Cabin(
                4, "Forest Edge Cabin", "Khulna, Sundarbans", 65.00, 3, hostB, true, 25.00
        );
        sundarbanCabin.addFacility(new Facility("Fire Pit", "Outdoor"));


        // 3. Print Listing (Demonstrating Polymorphism)
        System.out.println("--- SpareB&B High-Score Accommodation Listing (Sprint 1) ---");
        System.out.println("----------------------------------------------------------");

        System.out.println(gulshanFlat.printDetails());
        System.out.println("Estimated 3-Night Total Cost: $" + String.format("%.2f", gulshanFlat.calculateTotal(3)));
        System.out.println("----------------------------------------------------------");

        System.out.println(coxHotel.printDetails());
        System.out.println("Estimated 3-Night Total Cost: $" + String.format("%.2f", coxHotel.calculateTotal(3)));
        System.out.println("----------------------------------------------------------");

        System.out.println(srimongolVilla.printDetails());
        System.out.println("Estimated 3-Night Total Cost: $" + String.format("%.2f", srimongolVilla.calculateTotal(3)));
        System.out.println("----------------------------------------------------------");

        System.out.println(sundarbanCabin.printDetails());
        System.out.println("Estimated 4-Night Total Cost: $" + String.format("%.2f", sundarbanCabin.calculateTotal(4)));
        System.out.println("----------------------------------------------------------");

        // --- DEMONSTRATING ENUM (Type Safety) ---

        // Example 1: Check the default status
        System.out.println("--- ENUM DEMONSTRATION ---");
        System.out.println(gulshanFlat.getTitle() + " initial status: " + gulshanFlat.getStatus());

        // Example 2: Change the status using the enum constant
        coxHotel.setStatus(AccommodationStatus.BOOKED);
        System.out.println(coxHotel.getTitle() + " new status: " + coxHotel.getStatus());

        // Example 3: Change another status
        srimongolVilla.setStatus(AccommodationStatus.MAINTENANCE);
        System.out.println(srimongolVilla.getTitle() + " new status: " + srimongolVilla.getStatus());
        sundarbanCabin.setStatus(AccommodationStatus.BOOKED);
        System.out.println(sundarbanCabin.getTitle() + " new status: " + sundarbanCabin.getStatus());
        System.out.println("--------------------------");
    }
}