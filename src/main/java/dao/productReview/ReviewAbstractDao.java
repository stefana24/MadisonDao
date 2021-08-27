package dao.productReview;

import models.Review;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ReviewAbstractDao {
    public void saveReview(Review review);
    public List<Review> getAllReviews();
    public Review getReviewBySummary(String review);
    public void removeReview(Review review);
    public void updateReview(Review review) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;

}
