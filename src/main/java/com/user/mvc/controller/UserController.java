package com.user.mvc.controller;

import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.User;
import com.user.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "index";
    }

    @GetMapping()
    public List<UserDto> getUser() {
        return userService.getAll();
    }

    @PostMapping("")
    public String addUser(User user) {
        userService.addUser(user);
        return "user-add";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("username", username);
            return "admin-panel";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "index";
        }
    }

    @DeleteMapping()
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }


}
