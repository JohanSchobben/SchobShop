package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.command.RegistrationCommand;
import iac.schobshop.Schobshop.converter.AccountCommandToAccount;
import iac.schobshop.Schobshop.converter.AddressCommandToAddress;
import iac.schobshop.Schobshop.converter.CustomerCommandToCustomer;
import iac.schobshop.Schobshop.converter.FileToByteArray;
import iac.schobshop.Schobshop.exceptions.mvc.ObjectNotFoundException;
import iac.schobshop.Schobshop.model.Account;
import iac.schobshop.Schobshop.model.Address;
import iac.schobshop.Schobshop.model.Role;
import iac.schobshop.Schobshop.model.User;
import iac.schobshop.Schobshop.repository.RoleRepository;
import iac.schobshop.Schobshop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    private AccountCommandToAccount accountCommandToAccount;
    private AddressCommandToAddress addressCommandToAddress;
    private CustomerCommandToCustomer customerCommandToCustomer;
    private FileToByteArray fileToByteArray;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, AccountCommandToAccount accountCommandToAccount, AddressCommandToAddress addressCommandToAddress, CustomerCommandToCustomer customerCommandToCustomer, FileToByteArray fileToByteArray, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.accountCommandToAccount = accountCommandToAccount;
        this.addressCommandToAddress = addressCommandToAddress;
        this.customerCommandToCustomer = customerCommandToCustomer;
        this.fileToByteArray = fileToByteArray;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ObjectNotFoundException("user","email", email);
        }
        return user;
    }

    @Override
    public void saveUser(RegistrationCommand command) {
        User user = new User();
        user.setEmail(command.getAccount().getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(command.getAccount().getPassword()));
        user.setActive(true);

        Account account = accountCommandToAccount.convert(command.getAccount());
        Address address = addressCommandToAddress.convert(command.getAddress());

        account.setBillingAddress(address);
        account.setCustomer(customerCommandToCustomer.convert(command.getCustomer()));
        account.getCustomer().setAddress(address);
        account.setProfilePicture(fileToByteArray.convert(command.getAccount().getProfilePicture()));

        user.setAccount(account);
        Long userLong = 1L;
        Role role = roleRepository.findOne(userLong);
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
    }
}
