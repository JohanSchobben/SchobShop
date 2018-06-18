package iac.schobshop.Schobshop.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

public class AccountCommand {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 64, min = 8)
    private String password;
    @NotBlank
    private String passwordConfirm;
    private MultipartFile profilePicture;
    private AddressCommand addressCommand;
    private CustomerCommand customerCommand;

    public AccountCommand() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public AddressCommand getAddressCommand() {
        return addressCommand;
    }

    public void setAddressCommand(AddressCommand addressCommand) {
        this.addressCommand = addressCommand;
    }

    public CustomerCommand getCustomerCommand() {
        return customerCommand;
    }

    public void setCustomerCommand(CustomerCommand customerCommand) {
        this.customerCommand = customerCommand;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "AccountCommand{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", addressCommand=" + addressCommand +
                ", customerCommand=" + customerCommand +
                '}';
    }


}

