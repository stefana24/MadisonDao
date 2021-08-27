package com.tests;

import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.LoginSteps;
import tools.constants.MessageConstants;
import tools.constants.UserConstants;

public class LoginTest extends BaseTest{
    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginTest(){
        loginSteps.loginWithValidCredentials(UserConstants.EMAIL,UserConstants.PASSWORD);
        loginSteps.verifyUserLoggedIn(MessageConstants.WELCOME_MSG);
    }
}
