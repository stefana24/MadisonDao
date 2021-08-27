package dao.productReview;

import models.Review;
import tools.constants.SerenityKeyConstants;
import tools.utils.SerenitySessionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ReviewDao implements ReviewAbstractDao{
    @Override
    public void saveReview(Review review) {
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.REVIEW_LIST,review);
    }

    @Override
    public List<Review> getAllReviews() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.REVIEW_LIST);
    }

    @Override
    public void removeReview(Review review) {
        SerenitySessionUtils.removeObjectFromSerenitySessionList(SerenityKeyConstants.REVIEW_LIST,review);
    }

    @Override
    public void updateReview(Review review) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SerenitySessionUtils.replaceObjectInSerenitySessionList(SerenityKeyConstants.REVIEW_LIST,review,"summary",review.getSummary());
    }

    @Override
    public Review getReviewBySummary(String summary) {
        List<Review> list = getAllReviews();
        return list.stream().filter(element->element.getSummary().equalsIgnoreCase(summary)).findFirst().orElse(null);
    }
}
