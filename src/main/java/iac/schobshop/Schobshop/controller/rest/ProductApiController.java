package iac.schobshop.Schobshop.controller.rest;

import iac.schobshop.Schobshop.command.ApiProduct;
import iac.schobshop.Schobshop.converter.ApiProductToProduct;
import iac.schobshop.Schobshop.converter.ProductToApiProduct;
import iac.schobshop.Schobshop.model.Product;
import iac.schobshop.Schobshop.service.ProductService;
import liquibase.change.core.CreateProcedureChange;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {

    private ProductService productService;
    private ProductToApiProduct productToApiProduct;
    private ApiProductToProduct apiProductToProduct;

    public ProductApiController(ProductService productService, ProductToApiProduct productToApiProduct, ApiProductToProduct apiProductToProduct) {
        this.productService = productService;
        this.productToApiProduct = productToApiProduct;
        this.apiProductToProduct = apiProductToProduct;
    }

    @GetMapping
    public ArrayList<ApiProduct> getAllProducts(){
        Iterable<Product> products = productService.findAllProducts();
        ArrayList<ApiProduct> apiProducts = new ArrayList<>();
        for (Product product: products){
            apiProducts.add(productToApiProduct.convert(product));
        }
        return apiProducts;
    }
    @GetMapping(path = "/{id}")
    public ApiProduct getProduct(@PathVariable Long id){
        return productToApiProduct.convert(productService.findProduct(id));
    }

    @PostMapping()
    public ApiProduct CreateProduct(@Valid @RequestBody ApiProduct apiProduct){
        Product product = apiProductToProduct.convert(apiProduct);
        Product product1 = productService.createProduct(product);
        return productToApiProduct.convert(product1);
    }

    @PutMapping(path = "/{id}")
    public ApiProduct updateProduct(@RequestBody ApiProduct apiProduct, @PathVariable Long id){
        Product product = apiProductToProduct.convert(apiProduct);
        Product product1 = productService.updateProduct(id, product);
        return productToApiProduct.convert(product1);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }



}
