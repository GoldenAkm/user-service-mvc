package com.user.mvc.service;

import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.User;
import com.user.mvc.mapper.UserMapper;
import com.user.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void getUserById(Long id, Model model) {
        User user = userRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "User not found with given ID: " + id));

        model.addAttribute("user", user);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public void addUser(User user) {
        userRepository.save(user);
        log.info("User has been saved to db with username: {}", user.getUsername());
    }

    public User getUserByEmailAddress(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void updateUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
