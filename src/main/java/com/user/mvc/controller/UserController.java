package com.user.mvc.controller;

import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.User;
import com.user.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "index";  // TODO: change file name to login.html
    }

    @GetMapping
    public List<UserDto> getUser() {
        return userService.getAll();
    }

    @GetMapping("/page")
    public String getUserPage() {
        return "users";
    }

    @GetMapping("/dashboard/page")
    public String getDashboardPage() { // TODO: Exclude these methods to seperate class
        return "dashboard";
    }

    @GetMapping("/products")
    public String getProductsPage() {
        return "products";
    }

    @GetMapping("/orders")
    public String getOrdersPage() {
        return "orders";
    }

    @PostMapping
    public String addUser(User user) { // TODO: Change to entity
        userService.addUser(user);
        return "user-add";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserByEmailAddress(username);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("username", username);
            return "dashboard";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "index";
        }
    }

    @DeleteMapping
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }

}
