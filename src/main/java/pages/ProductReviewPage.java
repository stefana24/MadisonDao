package pages;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductReviewPage extends BasePage{

    @FindBy(css=".messages")
    private WebElement messagesContainer;

    public String findMessageByClassName(String className){
        return messagesContainer.findElement(By.className(className)).findElement(By.cssSelector("span")).getText();
    }

}
