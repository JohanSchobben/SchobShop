package iac.schobshop.Schobshop.controller;


import iac.schobshop.Schobshop.model.Account;
import iac.schobshop.Schobshop.service.AccountService;
import iac.schobshop.Schobshop.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class UserController {
    private UserService userService;
    private AccountService accountService;

    public UserController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(Model model){
        User springUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        iac.schobshop.Schobshop.model.User user = userService.findUserByEmail(springUser.getUsername());
        model.addAttribute("user", user );

        return "account/profile";
    }

    @RequestMapping(value = {"/profile/{id}/image"})
    public void RenderProfileImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Account account = accountService.findAccount(id);

        if (account.getProfilePicture() != null){
            byte[] byteArray = new byte[account.getProfilePicture().length];

            int i = 0;
            for (Byte wrapByte : account.getProfilePicture()){
                byteArray[i++] = wrapByte;
            }
            response.setContentType("image/jpeg");
            InputStream inputStream = new ByteArrayInputStream(byteArray);
            IOUtils.copy(inputStream,response.getOutputStream());
        }

    }
}
