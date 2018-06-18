package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Category;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryService {
    @Transactional
    Iterable<Category> findAllCategories();

    @Transactional
    Category findCategory(Long id);
}
