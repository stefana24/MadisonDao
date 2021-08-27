package dao.product;

import models.Product;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ProductAbstractDao {
    public void saveProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductByName(String productName);
    public void updateProduct(Product product) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
    public void removeProduct(Product product);
}
