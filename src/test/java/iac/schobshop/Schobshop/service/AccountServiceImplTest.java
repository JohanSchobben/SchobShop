package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Account;
import iac.schobshop.Schobshop.model.User;
import iac.schobshop.Schobshop.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    private AccountServiceImpl accountService;
    @Mock
    private AccountRepository accountRepository;



    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    public void findByUser() {
        String testEmail = "test@mail.com";
        Long userId = 1L;

        Long accountId = 2L;

        User user = new User();
        user.setEmail(testEmail);
        user.setId(userId);

        Account account = new Account();
        account.setId(accountId);
        account.setUser(user);

        when(accountRepository.findByUser_Email(testEmail)).thenReturn(account);

        Account account1 = accountService.findByUser(user);
        assertEquals(account, account1);
        // check if call has been made once
        verify(accountRepository, times(1)).findByUser_Email(user.getEmail());
    }

    @Test
    public void findByUserNull(){
        User user = new User(); // leave email null
        when(accountRepository.findByUser_Email(user.getEmail())).thenReturn(null);
        Account account = accountService.findByUser(user);
        assertNull(account);
        verify(accountRepository, times(1)).findByUser_Email(user.getEmail());
    }

    @Test
    public void findAccount() {
        Long accountId = 1L;
        Account account = new Account();
        account.setId(accountId);
        when(accountRepository.findOne(accountId)).thenReturn(account);
        Account accountResult = accountRepository.findOne(accountId);
        assertEquals(account, accountResult);
        verify(accountRepository, times(1)).findOne(accountId);
    }

    @Test
    public void findAccountNull(){
        Long accountId = 1L;
        when(accountRepository.findOne(accountId)).thenReturn(null);
        Account accountResult = accountRepository.findOne(accountId);
        assertNull(accountResult);
        verify(accountRepository, times(1)).findOne(accountId);
    }
}