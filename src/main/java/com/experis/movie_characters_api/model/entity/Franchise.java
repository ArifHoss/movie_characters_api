package com.experis.movie_characters_api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Franchise name can't be null!")
    private String name;
    @NotNull(message = "Franchise description can't be null!")
    private String description;

    @OneToMany
    @JoinTable(name = "franchise_movies",
            joinColumns = @JoinColumn(name = "franchise_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;


}
