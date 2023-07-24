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

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "email_address", nullable = false, unique = true)
    private String emailAddress;
    private String password;

}

