package com.user.mvc.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    private String password;
}
