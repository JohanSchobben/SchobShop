package iac.schobshop.Schobshop.controller;

import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.model.Product;
import iac.schobshop.Schobshop.service.CategoryService;
import iac.schobshop.Schobshop.service.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

@Controller
public class ProductController {
    private CategoryService categoryService;
    private ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping(value = "category/{id}")
    public String Categorypage(Model model, @PathVariable Long id){
        Category category = this.categoryService.findCategory(id);
        Iterable<Product> products = productService.findProductsByCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "shop/category";
    }
    @RequestMapping(value = "product/{id}")
    public String getPoductPage(Model model, @PathVariable Long id){
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "shop/product";
    }

    @RequestMapping(value = "product/{id}/image")
    public void getProductImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Product product = productService.findProduct(id);

        if (product.getProductImage() != null) {
            byte[] byteArray = new byte[product.getProductImage().length];

            int i = 0;
            for (Byte wrapByte : product.getProductImage()) {
                byteArray[i++] = wrapByte;
            }
            response.setContentType("image/jpeg");
            InputStream inputStream = new ByteArrayInputStream(byteArray);
            IOUtils.copy(inputStream, response.getOutputStream());
        }
    }
}
