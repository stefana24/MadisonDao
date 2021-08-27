package com.tests;

import factories.ReviewFactory;
import models.Review;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.GoToProductDetailsStep;
import steps.MagentoSteps;
import steps.ProductDetailsSteps;

public class ReviewTest extends BaseTest{

    @Steps
    private GoToProductDetailsStep helper;

    @Steps
    private ProductDetailsSteps productDetailsSteps;

    @Steps
    private MagentoSteps magentoSteps;

    @Test
    public void reviewTest(){
        helper.goToProductDetails("WOMEN","NEW ARRIVALS","Elizabeth Knit Top");
        Review review = ReviewFactory.getReviewInstance();
        productDetailsSteps.addReview(review);
        magentoSteps.acceptReviewAsAdmin();
        magentoSteps.returnToMadison();
        helper.goToProductDetails("WOMEN","NEW ARRIVALS","Elizabeth Knit Top");
        productDetailsSteps.seeReviews(review);


    }
}
