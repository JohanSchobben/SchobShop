package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.model.Product;

public interface ProductService {
    Iterable<Product> findProductsByCategory(Category category);

    boolean checkIfExist(Long id);
    Iterable<Product> findAllProducts();
    Product findProduct(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product createProduct(Product product);
}
