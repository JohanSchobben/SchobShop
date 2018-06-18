package iac.schobshop.Schobshop.repository;

import iac.schobshop.Schobshop.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT c.products FROM Category c WHERE c.id = :id")
    Optional<Category> getCategoryById(@Param("id") Long id);

}
