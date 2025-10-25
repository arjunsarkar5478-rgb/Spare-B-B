package sparebnb;

public class User {
    private int userId;
    private String firstName;
    private String email;

    public User(int userId, String firstName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
    }

    // Public Getters
    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}