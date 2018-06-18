package iac.schobshop.Schobshop.command;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

public class OrderCommand {
    @Valid
    private AddressCommand address;
    @AssertTrue
    private boolean confirmation;

    public AddressCommand getAddress() {
        return address;
    }

    public void setAddress(AddressCommand addressCommand) {
        this.address = addressCommand;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }
}
