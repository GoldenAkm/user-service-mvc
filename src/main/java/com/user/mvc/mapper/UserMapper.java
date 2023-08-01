package com.user.mvc.mapper;

import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper { // TODO: explore mapstruct and apply it to your project

    public UserDto toUserDto(User user) {
        var userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User toUser(UserDto userDto) {
        var user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmailAddress(userDto.getEmailAddress());
        return user;
    }

}
