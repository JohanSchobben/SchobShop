package iac.schobshop.Schobshop.command;


import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressCommand {

    @Size(min = 1, max = 50)
    private String street;
    @NotBlank
    @Size(min = 1, max = 20)
    private String number;
    @NotBlank
    @Pattern(regexp = "^[0-9]{4}[a-z]{2}$", message = "Postal code must start with 4 numbers and end with 2 small characters")
    private String postalCode;
    @Size(min = 2, max = 50)
    private String city;
    @Size(min = 2, max = 50)
    private String country;

    public AddressCommand() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AddressCommand{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
