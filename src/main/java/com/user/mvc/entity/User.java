package com.user.mvc.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @Column(name = "email_address")
    private String emailaddress;

    private String password;

}

