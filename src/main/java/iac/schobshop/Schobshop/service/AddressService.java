package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Address;

public interface AddressService {
    Address findAdressByEmail(String email);
}
