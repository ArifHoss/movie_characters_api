package com.experis.movie_characters_api.model.dto;

import lombok.Data;

import java.net.URL;
import java.util.List;
import java.util.Set;

@Data
public class MovieDto {

    private int id;
    private String title;
    private String genre;
    private String release_year;
    private String director_name;
    private URL movie_poster;
    private URL movie_trailer;
    private List<Integer> actors;
    private Integer franchise;

}
