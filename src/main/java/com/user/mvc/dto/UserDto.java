package com.user.mvc.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {
    private String username;

    @Column(name = "email_address")
    private String emailAddress;

    private String password;
}
