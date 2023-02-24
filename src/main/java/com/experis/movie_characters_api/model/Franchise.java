package com.experis.movie_characters_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private int id;
    private String name;
    private String description;

    @OneToMany
    @JoinTable(name = "franchise_movies",
            joinColumns = @JoinColumn(name = "franchise_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;


}
