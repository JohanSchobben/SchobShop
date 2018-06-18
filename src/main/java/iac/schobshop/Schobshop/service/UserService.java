package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.command.RegistrationCommand;
import iac.schobshop.Schobshop.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(RegistrationCommand user);
}
