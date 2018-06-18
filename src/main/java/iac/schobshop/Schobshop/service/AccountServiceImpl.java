package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Account;
import iac.schobshop.Schobshop.model.User;
import iac.schobshop.Schobshop.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public Account findByUser(User user){
        return accountRepository.findByUser_Email(user.getEmail());
    }

    @Override
    @Transactional
    public Account findAccount(Long id) {
        return accountRepository.findOne(id);
    }
}
