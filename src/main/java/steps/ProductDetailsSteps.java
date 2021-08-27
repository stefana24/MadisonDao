package steps;

import dao.product.ProductAbstractDao;
import dao.product.ProductDao;
import dao.productReview.ReviewAbstractDao;
import dao.productReview.ReviewDao;
import factories.ReviewFactory;
import models.Product;
import models.Review;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.ShoppingCartPage;
import tools.constants.MessageConstants;

import java.util.List;
import java.util.Locale;

public class ProductDetailsSteps {

    private ProductDetailsPage productDetailsPage;
    private ProductAbstractDao productDao = new ProductDao();
    private ReviewAbstractDao reviewDao = new ReviewDao();
    private ShoppingCartPage shoppingCartPage;
    private ProductReviewPage productReviewPage;

    public Product getProductDetails(){
        Product product = new Product();
        product.setProductName(productDetailsPage.getProductName());
        product.setPrice(productDetailsPage.getPrice());
        product.setColor(productDetailsPage.getProductColor());
        product.setSize(productDetailsPage.getProductSize());
        product.setQuantity(productDetailsPage.getRandomQuantity());
        return product;
    }

    @Step
    public void addToCart(){
        Product product = getProductDetails();
        double subtotal = product.getPrice()*product.getQuantity();
        product.setSubtotal(subtotal);
        productDetailsPage.clickOnAddToCart();
        productDao.saveProduct(product);

    }

    @Step
    public void addReview(Review review){
        productDetailsPage.clickToMakeReview();
        productDetailsPage.fillInReviewFields(review);
        productDetailsPage.clickOnSubmitReview();
        reviewDao.saveReview(review);
        Assert.assertEquals(productReviewPage.findMessageByClassName("error-msg"), MessageConstants.UNABLE_POST_REVIEW_MSG);
        Assert.assertEquals(productReviewPage.findMessageByClassName("success-msg"),MessageConstants.REVIEW_WAS_ACCEPTED_FOR_MODERATION);
    }

    @Step
    public void seeReviews(Review review){
        productDetailsPage.clickToSeeReviews();

        List<String> summaryList = productDetailsPage.getSummaryList();
        String review1 = reviewDao.getReviewBySummary(review.getSummary()).getSummary();

        Assert.assertTrue(summaryList.contains(review1.toLowerCase()));

    }


}
