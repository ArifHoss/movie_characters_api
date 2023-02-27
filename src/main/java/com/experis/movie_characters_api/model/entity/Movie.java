package com.experis.movie_characters_api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @NotNull(message = "Movie Title can't be null!")
    private String title;
    @NotNull(message = "Movie Genre can't be null!")
    private String genre;
    private String release_year;
    @NotNull(message = "Movie Director_name can't be null!")
    private String director_name;
    private URL movie_poster;
    private URL movie_trailer;

    @ManyToMany
    private Set<Actor> actors;
    @ManyToOne
    @JsonIgnore
    private Franchise franchise;




}
