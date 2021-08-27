package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage{

    private HeaderPage headerPage;

    @FindBy(css="#shopping-cart-table>tbody>tr")
    private List<WebElement> cartProducts;

    @FindBy(css="button[title='Empty Cart']")
    private WebElement emptyCartLink;


    public void clickOnEmptyCart(){
        clickOn(emptyCartLink);
    }


    public List<Product> getProductsFromCart(){
        List<Product> products = new ArrayList<>();
        for(WebElement productItem:cartProducts){
            Product product = new Product();
            product.setProductName(productItem.findElement(By.cssSelector("td.product-cart-info > h2 > a")).getText());
            product.setColor(productItem.findElement(By.cssSelector("td.product-cart-info > dl > dd:nth-child(2)")).getText());
            product.setSize(productItem.findElement(By.cssSelector("td.product-cart-info > dl > dd:nth-child(4)")).getText());
            String price = (productItem.findElement(By.cssSelector(".product-cart-price .cart-price .price")).getText()).substring(1);

            product.setPrice(Double.parseDouble(price));
            String qty = productItem.findElement(By.cssSelector("input[title='Qty']")).getAttribute("value");
            product.setQuantity(Integer.parseInt(qty));
            String subtotal = productItem.findElement(By.cssSelector(".product-cart-total .cart-price .price")).getText().substring(1);
            subtotal.replace(",","");
            product.setSubtotal(Double.parseDouble(subtotal));
            products.add(product);
        }

        return products;
    }

    public void makeSureCartIsEmpty(){
        if (!getDriver().findElement(By.cssSelector(".header-minicart>a")).getAttribute("class").contains("no-count")) {
            headerPage.clickOnCart();
            headerPage.clickOnViewShoppingCartLink();
            clickOnEmptyCart();
        }
    }

    public void updateProductQty(String productName, int quantityNo){
        for(WebElement product:cartProducts){
            if(product.findElement(By.cssSelector("td.product-cart-info > h2 > a")).getText().equalsIgnoreCase(productName)){
                typeInto(product.findElement(By.cssSelector("input[title='Qty']")),String.valueOf(quantityNo));
                clickOn(product.findElement(By.cssSelector("button[title='Update']")));
                break;
            }
        }

    }

    public void removeProductFromShoppingCart(String productName){
        for(WebElement product:cartProducts){
            if(product.findElement(By.cssSelector("td.product-cart-info > h2 > a")).getText().equalsIgnoreCase(productName)){
                clickOn(product.findElement(By.cssSelector("td[class*='product-cart-remove'] a[title='Remove Item']")));
                break;
            }
        }
    }

}
