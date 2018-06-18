package iac.schobshop.Schobshop.service;

import com.google.common.collect.Iterables;
import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void findAllCategories() {
        Category category = new Category();
        category.setId(1L);
        category.setName("test");
        Category category1 = new Category();
        category1.setId(2L);
        category1.setName("test2");

        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category);
        categorySet.add(category1);

        when(categoryRepository.findAll()).thenReturn(categorySet);

        Iterable<Category> categoriesResult = categoryService.findAllCategories();

        assertEquals(Iterables.size(categoriesResult), 2);
        verify(categoryRepository, times(1)).findAll();

    }

    @Test
    public void findAllCategoriesNull(){
        when(categoryRepository.findAll()).thenReturn(null);
        Iterable<Category> categoriesResult = categoryService.findAllCategories();
        assertNull(categoriesResult);
        verify(categoryRepository, times(1)).findAll();

    }

    @Test
    public void findCategory() {
        Long testLong = 1L;
        Category category = new Category();
        category.setId(1L);
        category.setName("test");
        when(categoryRepository.findOne(1L)).thenReturn(category);
        Category categoryResult = categoryService.findCategory(testLong);
        assertEquals(category, categoryResult);
        verify(categoryRepository, times(1)).findOne(testLong);

    }

    @Test
    public  void  findCategoryNull(){
        Long testLong = 1L;
        when(categoryRepository.findOne(1L)).thenReturn(null);
        Category categoryResult = categoryService.findCategory(testLong);
        assertNull(categoryResult);
        verify(categoryRepository, times(1)).findOne(testLong);
    }
}