package factories;

import models.Review;
import net.bytebuddy.utility.RandomString;

public class ReviewFactory {
    public static Review getReviewInstance(){
        Review review = new Review();
        review.setSummary(RandomString.make(10));
        review.setNickname(RandomString.make(10));
        review.setThoughts(RandomString.make(10));
        return review;
    }
}
