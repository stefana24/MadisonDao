package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage{

    @FindBy(css="#nav .nav-primary li[class*='level0'] > a")
    private List<WebElement> categoryElements;

    @FindBy(css=".account-cart-wrapper a[class*='skip-account']")
    private WebElement account;

    @FindBy(css=".account-cart-wrapper a[class*='skip-cart']")
    private WebElement cart;

    @FindBy(css=".minicart-actions .cart-link")
    private WebElement viewShoppingCartLink;

    @FindBy(css=".header-language-container .welcome-msg")
    private WebElement welcomeMessage;

    public String getWelcomeMsg(){
        return welcomeMessage.getText();
    }

    public void clickOnAccount(){
        clickOn(account);
    }

    public void clickOnCart(){
        clickOn(cart);
    }

    public void clickOnViewShoppingCartLink(){
        clickOn(viewShoppingCartLink);
    }

    public void clickOnALinkFromAccount(String title){
        getDriver().findElement(By.cssSelector("#header-account .links ul li a[title='"+title+"']")).click();
    }

    public void clickOnCategory(String categoryName){
        for(WebElement category:categoryElements){
            if(category.getText().equalsIgnoreCase(categoryName)){
                clickOn(category);
                break;
            }
        }
    }
}
