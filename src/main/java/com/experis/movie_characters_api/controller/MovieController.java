package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.MovieDto;
import com.experis.movie_characters_api.model.dto.MovieMapper;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.services.implementation.MovieServiceImpl;
import com.experis.movie_characters_api.services.service_view.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<MovieDto> getAllMovie() {
        // Retrieves all movies from the database and mapps them to a list of 'MovieDto' objects using 'MovieMapper' class.
        List<Movie> movies = movieService.getAllMovie();
        return movies.stream().map(movieMapper::toMovieDto).collect(Collectors.toList());
    }
}
