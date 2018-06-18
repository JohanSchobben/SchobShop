package iac.schobshop.Schobshop.repository;

import iac.schobshop.Schobshop.model.Category;
import iac.schobshop.Schobshop.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findProductsByCategoriesIs(Category category);
    Optional<Product> findProductById(Long id);
}
