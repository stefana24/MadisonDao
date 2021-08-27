package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class BasePage extends PageObject {
    public void populateInputField(String name,String value){
        typeInto(getDriver().findElement(By.cssSelector("input[name='"+name+"']")),value);
    }

}
