package com.web.news.User.Controller;

import java.util.Set;

import com.web.news.User.Domain.UserDto;
import com.web.news.User.Service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {
    
    @Autowired
    private IUserService userService;

    @GetMapping("/user/{username}")
    public String getDetailUser(@PathVariable String username,Model model) {
        UserDto userDto = userService.getUserDetail(username);
        String message = "Hello " + userDto.getUsername();
        Set<String> roles = userDto.getRoles();
        model.addAttribute("user", userDto);
        model.addAttribute("message", message);
        model.addAttribute("roles", roles);
        return "User/UserDetail";
    }

    @GetMapping("/register")
    public String createUser(@ModelAttribute("user") UserDto userDto, Model model) {
        model.addAttribute("user", userDto);
        return "User/CreateUserForm";
    }

    @PostMapping("/register")
    public String createUser(UserDto userDto){
        Boolean validate = userService.validateUser(userDto.getUsername());
        if(validate == false) {
            return "redirect:/register?message=fail";
        }
        userService.register(userDto);
        return "redirect:/login";
    }

    @GetMapping("/user/{username}/changePassword") 
    public String changePasswordForm(@ModelAttribute("user") UserDto userDto, @PathVariable String username, Model model) {
        userDto = userService.getUserDetail(username);
        model.addAttribute("user", userDto);
        return "User/ChangePasswordForm";
    }

    @PutMapping("/user/{username}/changePassword")
    public String changePasswordForm(UserDto userDto, @PathVariable String username){
        userDto.setUsername(username);
        userService.changePassword(userDto);
        return "redirect:/user/{username}";
    }
    
}
