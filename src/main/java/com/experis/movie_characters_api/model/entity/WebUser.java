package com.experis.movie_characters_api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "webuser")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class WebUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int webuser_id;
    private String name;
    private String email;
    @Transient
    private String password;
    private String role; // DEVELOPER, ADMIN and USER
}
