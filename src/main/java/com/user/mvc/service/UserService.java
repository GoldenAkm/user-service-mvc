package com.user.mvc.service;

import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.User;
import com.user.mvc.mapper.UserMapper;
import com.user.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserMapper userMapper;

    public List<UserDto> getAll(){
        return userRepository.findAll().stream()
                .map(userMapper :: toUserDto).collect(Collectors.toList());
    }
    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }


    @Transactional
    public void updateUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
