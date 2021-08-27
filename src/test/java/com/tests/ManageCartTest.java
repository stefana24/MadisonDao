package com.tests;

import factories.UserFactory;
import models.User;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import pages.HeaderPage;
import steps.*;
import tools.constants.UserConstants;

import java.lang.reflect.InvocationTargetException;

public class ManageCartTest extends BaseTest{
    @Steps
    private HeaderSteps headerSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private GoToProductDetailsStep helper;

    @Steps
    private ShoppingCartSteps shoppingCartSteps;

    @Steps
    private ProductDetailsSteps productDetailsSteps;

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void shoppingCartTest001(){
        registerSteps.goToRegister();
        User user = UserFactory.generateUser();
        registerSteps.registerUser(user);
        shoppingCartSteps.emptyShoppingCart();
        helper.goToProductDetails("WOMEN","PANTS & DENIM","TriBeCa Skinny Jean");
        productDetailsSteps.addToCart();
        shoppingCartSteps.verifyProductsAreInShoppingCart();
    }

    @Test
    public void shoppingCartTest002() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        loginSteps.loginWithValidCredentials(UserConstants.EMAIL,UserConstants.PASSWORD);
        shoppingCartSteps.emptyShoppingCart();
        helper.goToProductDetails("WOMEN","NEW ARRIVALS","Elizabeth Knit Top");
        productDetailsSteps.addToCart();
        helper.goToProductDetails("men","NEW ARRIVALS","Linen Blazer");
        productDetailsSteps.addToCart();

        shoppingCartSteps.updateProduct("Elizabeth Knit Top",2);
        shoppingCartSteps.verifyProductsAreInShoppingCart();
        shoppingCartSteps.removeProduct("Elizabeth Knit Top");
    }

}
