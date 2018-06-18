package iac.schobshop.Schobshop.command;

import javax.validation.constraints.Size;

public class CustomerCommand {
    @Size(min = 1, max = 50)
    private String firstName;
    @Size(min = 1, max = 50)
    private String lastName;

    public CustomerCommand() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CustomerCommand{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
