package sparebnb;

import java.util.Date;

public class Review {
    private int rating;
    private String comment;
    private Date reviewDate;

    public Review(int rating, String comment, Date reviewDate) {
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}