package iac.schobshop.Schobshop.repository;

import iac.schobshop.Schobshop.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long>{
    Address findAddressByAccount_Email(String email);
}
