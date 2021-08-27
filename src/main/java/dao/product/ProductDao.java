package dao.product;

import models.Product;
import tools.constants.SerenityKeyConstants;
import tools.utils.SerenitySessionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ProductDao implements ProductAbstractDao{
    @Override
    public void saveProduct(Product product) {
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.CART_PRODUCTS_LIST,product);
    }

    @Override
    public List<Product> getAllProducts() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.CART_PRODUCTS_LIST);
    }

    @Override
    public Product getProductByName(String productName) {
        List<Product> products = getAllProducts();
        return products.stream().filter(product -> product.getProductName().equalsIgnoreCase(productName)).findFirst().orElse(null);
    }

    @Override
    public void updateProduct(Product product) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SerenitySessionUtils.replaceObjectInSerenitySessionList(SerenityKeyConstants.CART_PRODUCTS_LIST,product,"productName",product.getProductName());
    }

    @Override
    public void removeProduct(Product product) {
        SerenitySessionUtils.removeObjectFromSerenitySessionList(SerenityKeyConstants.CART_PRODUCTS_LIST,product);
    }
}
