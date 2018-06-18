package iac.schobshop.Schobshop.controller;


import iac.schobshop.Schobshop.command.RegistrationCommand;
import iac.schobshop.Schobshop.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {
    private UserService userService;



    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "account/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model){
        model.addAttribute("registration", new RegistrationCommand());
        return "account/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@Valid @ModelAttribute("registration") RegistrationCommand registrationCommand, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "account/register";
        }
        userService.saveUser(registrationCommand);
        return "redirect:/profile";
    }
}
