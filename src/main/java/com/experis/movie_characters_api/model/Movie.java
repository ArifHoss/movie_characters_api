package com.experis.movie_characters_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    private String title;
    private String genre;
    private String release_year;
    private String director_name;
    private URL movie_poster;
    private URL movie_trailer;

    @ManyToMany
    private Set<Character> characters;
    @ManyToOne
    private Franchise franchise;




}
