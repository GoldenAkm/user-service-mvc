package com.user.mvc.controller;

import com.user.mvc.entity.User;
import com.user.mvc.mapper.UserMapper;
import com.user.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/sign-in")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("username", username); // TODO: use userdetailsserviceimpl and use jwtservice functions
            return "dashboard/dashboard";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }
}
