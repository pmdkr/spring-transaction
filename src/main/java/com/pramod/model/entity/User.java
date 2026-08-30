package com.pramod.model.entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
@Table(name = "Bank-users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long balance;


}
