package steps;

import dao.product.ProductAbstractDao;
import dao.product.ProductDao;
import models.Product;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.ShoppingCartPage;

import java.lang.reflect.InvocationTargetException;


public class ShoppingCartSteps {

    private ProductAbstractDao productDao = new ProductDao();
    private ShoppingCartPage shoppingCartPage;

    @Step
    public void emptyShoppingCart(){
        shoppingCartPage.makeSureCartIsEmpty();
    }

    @Step
    public void verifyProductsAreInShoppingCart(){
        Assert.assertEquals(shoppingCartPage.getProductsFromCart(),productDao.getAllProducts());
    }

    @Step
    public void updateProduct(String productName,int qty) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        shoppingCartPage.updateProductQty(productName,qty);

        Product old = productDao.getProductByName(productName);
        old.setQuantity(qty);
        old.setSubtotal(old.getPrice()*qty);
       //productDao.updateProduct(old);
    }

    @Step
    public void removeProduct(String productName){
        shoppingCartPage.removeProductFromShoppingCart(productName);
        Product product = productDao.getProductByName(productName);
        productDao.removeProduct(product);

    }

}
