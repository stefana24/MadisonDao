package pages;

public class HomePage extends BasePage{

    public void navigateToHomePage(){
        getDriver().get("http://qa2.dev.evozon.com/");
    }
}
