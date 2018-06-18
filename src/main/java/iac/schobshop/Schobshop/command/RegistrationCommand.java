package iac.schobshop.Schobshop.command;


import javax.validation.Valid;

/*
 * this POJO will be converted to an Account / Customer / Address and  via the userService
 * By default billingAddress and addres are the same, user can change them later on on their profile page
 */
public class RegistrationCommand {
    @Valid
    private AccountCommand account;
    @Valid
    private CustomerCommand customer;
    @Valid
    private AddressCommand address;

    public RegistrationCommand() {
    }

    public AccountCommand getAccount() {
        return account;
    }

    public void setAccount(AccountCommand account) {
        this.account = account;
    }

    public CustomerCommand getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerCommand customer) {
        this.customer = customer;
    }

    public AddressCommand getAddress() {
        return address;
    }

    public void setAddress(AddressCommand address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RegistrationCommand{" +
                "account=" + account.toString() +
                ", customer=" + customer .toString() +
                ", address=" + address .toString()+
                '}';
    }
}
