package com.practice.solarmng.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
}
