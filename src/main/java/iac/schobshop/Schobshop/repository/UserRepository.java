package iac.schobshop.Schobshop.repository;

import iac.schobshop.Schobshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
}
