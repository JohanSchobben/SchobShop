package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.converter.AccountCommandToAccount;
import iac.schobshop.Schobshop.converter.AddressCommandToAddress;
import iac.schobshop.Schobshop.converter.CustomerCommandToCustomer;
import iac.schobshop.Schobshop.converter.FileToByteArray;
import iac.schobshop.Schobshop.exceptions.mvc.ObjectNotFoundException;
import iac.schobshop.Schobshop.model.User;
import iac.schobshop.Schobshop.repository.RoleRepository;
import iac.schobshop.Schobshop.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock
    private RoleRepository roleRepository;
    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountCommandToAccount accountCommandToAccount;
    @Mock
    private AddressCommandToAddress addressCommandToAddress;
    @Mock
    private CustomerCommandToCustomer customerCommandToCustomer;
    @Mock
    private FileToByteArray fileToByteArray;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(roleRepository,userRepository,accountCommandToAccount,addressCommandToAddress,customerCommandToCustomer,fileToByteArray,bCryptPasswordEncoder);
    }

    @Test
    public void findUserByEmail() {
        String email = "test@mail.com";
        User user = new User();
        user.setId(1L);
        when(userRepository.findByEmail(email)).thenReturn(user);

        User userResult = userService.findUserByEmail(email);

        assertEquals(user, userResult);

        verify(userRepository, times(1)).findByEmail(email);

    }
    @Test(expected = ObjectNotFoundException.class)
    public void findUserByEmailNull() {
        String email = "test@mail.com";
        User user = new User();
        user.setId(1L);
        when(userRepository.findByEmail(email)).thenReturn(null);

        User userResult = userService.findUserByEmail(email);
        verify(userRepository, times(1)).findByEmail(email);

    }

    @Test
    public void saveUser() {

    }
}