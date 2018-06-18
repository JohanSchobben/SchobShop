package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.exceptions.mvc.DeleteException;
import iac.schobshop.Schobshop.exceptions.mvc.ObjectNotFoundException;
import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.model.Product;
import iac.schobshop.Schobshop.repository.ProductRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public Iterable<Product> findProductsByCategory(Category category) {
        return productRepository.findProductsByCategoriesIs(category);
    }

    @Override
    public boolean checkIfExist(Long id) {
        return productRepository.exists(id);
    }

    @Override
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(Long id) {
        Optional<Product> product = productRepository.findProductById(id);
        if (!product.isPresent()){
            throw new ObjectNotFoundException("product", "id", id.toString());
        }
        return product.get();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (!productRepository.exists(id)){
            throw new ObjectNotFoundException("prduct", "id", id.toString());
        }

        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        if (!checkIfExist(id)){
            throw new ObjectNotFoundException("Product", "id", id.toString());
        }
        try {
            productRepository.delete(id);
        }catch (DataIntegrityViolationException e){
            throw new DeleteException("Can not delete Sold items");
        }
    }

    @Override
    public Product createProduct(Product product) {
        Category categoryNew = categoryService.findCategory(1L);

        Set<Category>  categories = new HashSet<>();
        categories.add(categoryNew);
        product.setCategories(categories);

        productRepository.save(product);

        return product;
    }
}
