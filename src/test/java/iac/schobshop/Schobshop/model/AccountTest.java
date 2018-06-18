package iac.schobshop.Schobshop.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

private Account account;
    @Before
    public void setUp() throws Exception {
        account = new Account();
    }

    @Test
    public void getId() {
        Long id = 2L;
        account.setId(id);
        assertEquals(id, account.getId());
    }

    @Test
    public void getEmail() {
        String email = "test@email.com";
        account.setEmail(email);
        assertEquals(email,account.getEmail());
    }
}