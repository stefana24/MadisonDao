package com.tests;

import factories.UserFactory;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.RegisterSteps;

public class RegisterTest extends BaseTest{

    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void registerTest(){
        registerSteps.goToRegister();
        registerSteps.registerUser(UserFactory.generateUser());
    }
}
