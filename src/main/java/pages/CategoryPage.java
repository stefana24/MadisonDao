package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {
    @FindBy(css=".catblocks li a span")
    private List<WebElement> subcategoryElements;

    public void clickOnSubcategory(String subcategoryName){
        for(WebElement element:subcategoryElements){
            if(element.getText().equalsIgnoreCase(subcategoryName)){
                clickOn(element);
                break;
            }
        }
    }
}
