package pages;

import org.openqa.selenium.By;

public class SubcategoryPage extends BasePage{
    public void clickOnProduct(String title){
        getDriver().findElement(By.cssSelector("ul[class*='products-grid'] .product-info h2 a[title='"+title+"']")).click();
    }
}
