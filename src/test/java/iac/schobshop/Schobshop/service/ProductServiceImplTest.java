package iac.schobshop.Schobshop.service;

import com.google.common.collect.Iterables;
import iac.schobshop.Schobshop.exceptions.mvc.ObjectNotFoundException;
import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.model.Product;
import iac.schobshop.Schobshop.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository, categoryService);
    }

    @Test
    public void findProductsByCategory() {
        Product product = new Product();
        product.setId(1L);

        Product product1 = new Product();
        product1.setId(2L);

        Set<Product> productSet = new HashSet<>();
        productSet.add(product);
        productSet.add(product1);

        Category category = new Category();

        when(productRepository.findProductsByCategoriesIs(category)).thenReturn(productSet);

        Iterable<Product> productsResult = productRepository.findProductsByCategoriesIs(category);
        assertEquals(Iterables.size(productsResult), 2);
        verify(productRepository, times(1)).findProductsByCategoriesIs(category);

    }

    @Test
    public void findProduct() {
        Long testId = 1L;

        Product product = new Product();
        product.setId(testId);

        when(productRepository.findProductById(testId)).thenReturn(Optional.of(product));
        Product productResult =  productService.findProduct(testId);

        assertEquals(product,productResult);
        verify(productRepository, times(1)).findProductById(testId);

    }

    @Test(expected = ObjectNotFoundException.class)
    public void findProductNull() {
        Long testId = 1L;

        Product product = new Product();
        product.setId(testId);

        when(productRepository.findProductById(testId)).thenReturn(Optional.empty());
        Product productResult =  productService.findProduct(testId);
    }
}