package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Account;
import iac.schobshop.Schobshop.model.User;

public interface AccountService {
    Account findByUser(User user);

    Account findAccount(Long id);
}
