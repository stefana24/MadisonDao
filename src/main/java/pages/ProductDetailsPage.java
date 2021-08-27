package pages;

import models.Review;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ProductDetailsPage extends BasePage{

    @FindBy(css=".product-name .h1")
    private WebElement productName;

    @FindBy(css="div[class='price-info'] span[class*='regular-price'] span")
    private WebElement productPrice;

    @FindBy(css="#configurable_swatch_color li a")
    private List<WebElement> colorsList;

    @FindBy(css="#configurable_swatch_size li:not(.not-available) a")
    private List<WebElement> sizesList;

    @FindBy(css="input[name='qty']")
    private WebElement qtyElement;

    @FindBy(css=".toggle-tabs .last")
    private WebElement review;

    @FindBy(css="#customer-reviews > p > a")
    private WebElement firstReview;

    @FindBy(css="button[title='Submit Review']")
    private WebElement submitReviewBtn;

    @FindBy(css="tr[class*='first'] td.value")
    private List<WebElement> qualityRadioBtnList;

    @FindBy(css="tr.even td.value")
    private List<WebElement>priceRadioBtnList;

    @FindBy(css="tr[class='last odd'] td.value")
    private List<WebElement>valueRadioBtnList;

    @FindBy(css=".ratings  .rating-links a:nth-child(3)")
    private WebElement addYourReview;

    @FindBy(css=".rating-links>a:first-child")
    private WebElement ratingReviews;

    @FindBy(css="dt a")
    private List<WebElement> summaryList;

    public List<String> getSummaryList(){
        List<String> stringSummary = new ArrayList<>();
        for(WebElement element:summaryList){
            stringSummary.add(element.getText().toLowerCase());
        }
        return stringSummary;
    }


    public void clickToSeeReviews(){
        clickOn(ratingReviews);
    }


    public String getProductName(){
        return productName.getText();
    }

    public Double getPrice(){
        return Double.parseDouble(productPrice.getText().substring(1));
    }

    public String getProductColor() {
        WebElement colorElement = getElementFromList(colorsList);
        colorElement.click();
        return colorElement.getAttribute("title");
    }

    public String getProductSize() {
        WebElement sizeElement = getElementFromList(sizesList);
        clickOn(sizeElement);
        return sizeElement.getAttribute("title");
    }

    public WebElement getElementFromList(List<WebElement> list){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public int getRandomQuantity(){
        int min =1;
        int max = 5;
        Random random = new Random();
        int randQty =  random.nextInt(max-min+1)+min;
        qtyElement.clear();
        qtyElement.sendKeys(String.valueOf(randQty));
        return randQty;
    }

    public void clickOnAddToCart(){
        getDriver().findElement(By.cssSelector(".add-to-cart-buttons button[class*='btn-cart']")).click();
    }


    public void clickToMakeReview(){
//        clickOn(review);
//        clickOn(firstReview);
        clickOn(addYourReview);
    }

    public void fillInReviewFields(Review review){
        rateProduct();
        typeInto(getDriver().findElement(By.cssSelector(".form-list .input-box #review_field")), review.getThoughts());
        populateInputField("title", review.getSummary());
        populateInputField("nickname", review.getNickname());

    }

    public void selectQuality(){
        WebElement quality = getElementFromList(qualityRadioBtnList);
        clickOn(quality);
    }

    public void selectPrice(){
        WebElement price = getElementFromList(priceRadioBtnList);
        clickOn(price);
    }

    public void selectValue(){
        WebElement value = getElementFromList(valueRadioBtnList);
        clickOn(value);
    }

    public void rateProduct(){
        selectQuality();
        selectPrice();
        selectValue();
    }

    public void clickOnSubmitReview(){
        clickOn(submitReviewBtn);
    }
}
