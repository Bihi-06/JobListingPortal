package com.example.joblistingportal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
    private String pictureUrl;

    @Enumerated(EnumType.STRING)
    private CurrentJob currentJob;

    @Enumerated(EnumType.STRING)
    private Role role;

}
