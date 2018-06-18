package iac.schobshop.Schobshop.service;


import iac.schobshop.Schobshop.exceptions.mvc.ObjectNotFoundException;
import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category findCategory(Long id){
        return categoryRepository.findOne(id);
    }
}
