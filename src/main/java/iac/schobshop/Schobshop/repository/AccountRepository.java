package iac.schobshop.Schobshop.repository;

import iac.schobshop.Schobshop.model.Account;
import iac.schobshop.Schobshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUser_Email(String email);

}
