package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.MovieDto;
import com.experis.movie_characters_api.model.dto.MovieMapper;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.services.service_view.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "Movie", description = "Operations related to managing movie.")
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
        List<Movie> movies = movieService.getAll();
        return movies.stream().map(movieMapper::toMovieDto).collect(Collectors.toList());
    }


    @GetMapping("/{movieId}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public MovieDto getMovieByID(@PathVariable("movieId") int movieId) {
        Movie movie = movieService.getById(movieId);
        return movieMapper.toMovieDto(movie);
    }
    @GetMapping("/name")
    @ResponseStatus(value = HttpStatus.FOUND)
    public MovieDto getMovieName(String name) {
        Movie movie = movieService.getByName(name);
        return movieMapper.toMovieDto(movie);
    }
    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MovieDto createMovie(@RequestBody Movie movie) {
       Movie createMovie = movieService.create(movie);
        return movieMapper.toMovieDto(createMovie);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteMovie(@PathVariable("movieId") int id) {
        movieService.delete(id);
        return "Movie removed";
    }

    @PatchMapping("/update/{movieId}")
    public MovieDto updateMovie(@RequestBody Movie movie,@PathVariable("movieId")int id) {
        Movie updatedMovie = movieService.update(movie, id);
        return movieMapper.toMovieDto(updatedMovie);
    }
}
