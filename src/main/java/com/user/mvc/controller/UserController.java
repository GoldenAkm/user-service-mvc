package com.user.mvc.controller;

import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.User;
import com.user.mvc.mapper.UserMapper;
import com.user.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController { // TODO: create a single responsibility for each endpoint

    private final UserMapper userMapper;
    private final UserService userService;



    @GetMapping
    public List<UserDto> getUser() {
        return userService.getAll();
    }

    @GetMapping("/page")
    public String getUserPage() {
        return "users/users";
    }

    @PostMapping
    public String addUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userService.addUser(user);
        return "user-add";
    }

    @DeleteMapping()
    public void deleteUserById(Long id) { // TODO: make it with username
        userService.deleteUserById(id);
    }

}
