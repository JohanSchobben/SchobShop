package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Address;
import iac.schobshop.Schobshop.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findAdressByEmail(String email) {
        return addressRepository.findAddressByAccount_Email(email);
    }
}
