package com.web.news.Security.ApiController;

import java.security.Principal;

import com.web.news.User.Domain.UserPrincipal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value={"/", "/home"})
    public String homePage(){
        return "Home";
    }

    @GetMapping("/403")
    public String accessDeniedPage(Model model, Principal principal){
        if (principal != null) {
            UserPrincipal loginedUser = (UserPrincipal)((Authentication) principal).getPrincipal();
            String message = loginedUser.getUsername() + " do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403";
    }
    
    @GetMapping("/login")
    public String loginForm(){
        return "LoginForm";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

}
