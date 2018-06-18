package iac.schobshop.Schobshop.controller;

import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping({"","/","index"})
    public String index(Model model, HttpServletRequest request){
        return "index";
    }
//
//    @RequestMapping(value = "category/{id}")
//    public String Categorypage(Model model, @PathVariable Long id){
//        Category category = this.categoryService.findCategory(id);
//        Iterable<Product> products = productService.findProductsByCategory(category);
//        model.addAttribute("category", category);
//        model.addAttribute("products", products);
//        return "shop/category";
//    }
}
