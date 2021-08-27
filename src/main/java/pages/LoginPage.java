package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.constants.UserConstants;

public class LoginPage extends BasePage{
    @FindBy(name="login[username]")
    private WebElement emailInput;

    @FindBy(name="login[password]")
    private WebElement passwordInput;

    @FindBy(name="send")
    private WebElement loginBtn;

    public void setEmailInput(String email){
        typeInto(emailInput,email);
    }

    public void setPasswordInput(String password){
        typeInto(passwordInput,password);
    }

    public void clickOnLoginBtn(){
        clickOn(loginBtn);
    }

    public void logIn(String email, String password){
        setEmailInput(email);
        setPasswordInput(password);
        clickOnLoginBtn();
    }
}
