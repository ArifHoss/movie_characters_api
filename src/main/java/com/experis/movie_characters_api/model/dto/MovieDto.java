package com.experis.movie_characters_api.model.dto;

import lombok.Data;

import java.net.URL;
import java.util.Set;

@Data
public class MovieDto {

    private int id;
    private String title;
    private String genre;
    private String release_year;
    private URL movie_poster;
    private URL movie_trailer;
    private Set<Integer> actors;
    private Integer franchise;

}
