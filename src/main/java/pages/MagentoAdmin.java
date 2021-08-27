package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MagentoAdmin extends BasePage{

    @FindBy(css="input[title='Login']")
    private WebElement magentoLoginBtn;

    private LoginPage loginPage;

    @FindBy(css="#reviwGrid_table > tbody > tr:nth-child(1) > td.last > a")
    private WebElement editLink;

    @FindBy(css="button[title='Save Review']")
    private WebElement saveReview;

    @FindBy(css="select[name='status_id'] option[value='1']")
    private WebElement approved;

    public void logInAsAdmin(String user,String password){
        getDriver().get("http://qa2.dev.evozon.com/admin");
        loginPage.setEmailInput(user);
        loginPage.setPasswordInput(password);
        clickOn(magentoLoginBtn);
    }

    public void clickOnPendingReview(){
        //close incoming message
        getDriver().findElement(By.cssSelector("#message-popup-window > div.message-popup-head > a > span")).click();
        navigateThroughCategories("Catalog", "Reviews and Ratings", "Customer Reviews", "Pending Reviews");
    }

    public void editReview(){
        clickOn(editLink);
        clickOn(getDriver().findElement(By.cssSelector("#status_id")));
        clickOn(approved);

        clickOn(saveReview);
    }

    public void navigateThroughCategories(String... pathNodes) {
        Actions actions = new Actions(getDriver());
        for (int i = 0; i < pathNodes.length; i++) {
            WebElement currentElement = getDriver().findElement(By.xpath("//ul/li[a/span[text()='" + pathNodes[i] + "']]"));
            actions.moveToElement(currentElement).perform();
            actions.click().perform();
        }
    }


}
