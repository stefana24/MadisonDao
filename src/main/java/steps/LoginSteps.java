package steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.HeaderPage;
import pages.LoginPage;
import tools.constants.UserConstants;

public class LoginSteps {
    private LoginPage loginPage;
    private HeaderPage headerPage;

    @Step
    public void loginWithValidCredentials(String email,String password){
        headerPage.clickOnAccount();
        headerPage.clickOnALinkFromAccount("Log In");
        loginPage.logIn(email,password);
    }

    @Step
    public void verifyUserLoggedIn(String welcomeMsg){
        Assert.assertTrue(headerPage.getWelcomeMsg().equalsIgnoreCase(welcomeMsg));
    }
}
