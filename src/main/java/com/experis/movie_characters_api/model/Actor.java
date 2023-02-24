package com.experis.movie_characters_api.model;

import com.experis.movie_characters_api.enums.GenderType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;
    private String first_name;
    private String last_name;
    private String alias;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @ManyToMany
    private Set<Movie> movies;

}
