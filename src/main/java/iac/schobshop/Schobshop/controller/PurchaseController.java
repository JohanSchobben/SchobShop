package iac.schobshop.Schobshop.controller;

import iac.schobshop.Schobshop.command.OrderCommand;
import iac.schobshop.Schobshop.converter.AddressCommandToAddress;
import iac.schobshop.Schobshop.converter.AddressToAddressCommand;
import iac.schobshop.Schobshop.converter.ShoppingCartToPurchase;
import iac.schobshop.Schobshop.model.Address;
import iac.schobshop.Schobshop.model.Purchase;
import iac.schobshop.Schobshop.model.PurchaseState;
import iac.schobshop.Schobshop.model.ShoppingCart;
import iac.schobshop.Schobshop.service.AccountService;
import iac.schobshop.Schobshop.service.AddressService;
import iac.schobshop.Schobshop.service.PurchaseService;
import iac.schobshop.Schobshop.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class PurchaseController {

    private ShoppingCartToPurchase shoppingCartToPurchase;
    private AddressService addressService;
    private UserService userService;
    private AccountService accountService;
    private AddressToAddressCommand addressToAddressCommand;
    private AddressCommandToAddress addressCommandToAddress;
    private PurchaseService purchaseService;

    public PurchaseController(ShoppingCartToPurchase shoppingCartToPurchase, AddressService addressService, UserService userService, AccountService accountService, AddressToAddressCommand addressToAddressCommand, AddressCommandToAddress addressCommandToAddress, PurchaseService purchaseService) {
        this.shoppingCartToPurchase = shoppingCartToPurchase;
        this.addressService = addressService;
        this.userService = userService;
        this.accountService = accountService;
        this.addressToAddressCommand = addressToAddressCommand;
        this.addressCommandToAddress = addressCommandToAddress;
        this.purchaseService = purchaseService;
    }

    @RequestMapping(value = "/order")
    public String makeOrder(Model model, HttpSession session){
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if(shoppingCart.getItems().size() == 0){
            return "redirect:/";
        }
        Purchase purchase = shoppingCartToPurchase.convert(shoppingCart);
        purchase.setPurchaseDate(new Date());
        User springUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        iac.schobshop.Schobshop.model.User user = userService.findUserByEmail(springUser.getUsername());
        Address address =  addressService.findAdressByEmail(user.getAccount().getEmail());
        purchase.setPurchaseState(PurchaseState.IN_PROGRESS);
        purchase.setAccount(accountService.findByUser(user));
        OrderCommand orderCommand = new OrderCommand();
        orderCommand.setAddress(addressToAddressCommand.convert(address));
        session.setAttribute("purchase", purchase);
        model.addAttribute("purchaseCommand", orderCommand);
        return "shop/order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String makeOrder(@Valid @ModelAttribute("purchasecommand") OrderCommand orderCommand, HttpSession session, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "shop/order";
        }
        Address address = addressCommandToAddress.convert(orderCommand.getAddress());
        Purchase purchase = (Purchase) session.getAttribute("purchase");
        purchase.setDeliveryAddress(address);
        purchaseService.savePurchase(purchase);
        session.removeAttribute("shoppingCart");
        session.removeAttribute("purchase");
        return "redirect:/";
    }
}
