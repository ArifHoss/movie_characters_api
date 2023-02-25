package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.model.entity.Movie;

public interface MovieMapper {
    MovieDto toMovieDto(Movie movie);

    Movie toMovie(MovieDto dto);
}
