package iac.schobshop.Schobshop.controller.advices;

import iac.schobshop.Schobshop.service.CategoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class HeaderAdvice {

    private CategoryService categoryService;

    public HeaderAdvice(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ModelAttribute
    public void setHeaderData(Model model){
        model.addAttribute("categories", this.categoryService.findAllCategories());
    }
}
