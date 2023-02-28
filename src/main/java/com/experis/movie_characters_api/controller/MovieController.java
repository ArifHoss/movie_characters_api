package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.MovieDto;
import com.experis.movie_characters_api.model.dto.MovieMapper;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.services.service_view.MovieService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "GET ALL MOVIES")
    @GetMapping //http://localhost:8080/api/movie
    @ResponseStatus(value = HttpStatus.OK)
    public List<MovieDto> getAllMovie() {
        // Retrieves all movies from the database and mapps them to a list of 'MovieDto' objects using 'MovieMapper' class.
        List<Movie> movies = movieService.getAll();
        return movies.stream().map(movieMapper::toMovieDto).collect(Collectors.toList());
    }

    @Operation(summary = "GET MOVIE BY ID")
    @GetMapping("/{movieId}") //http://localhost:8080/api/movie/{Id}
    @ResponseStatus(value = HttpStatus.FOUND)
    public MovieDto getMovieByID(@PathVariable("movieId") int movieId) {
        Movie movie = movieService.getById(movieId);
        return movieMapper.toMovieDto(movie);
    }

    @Operation(summary = "GET MOVIE BY NAME")
    @GetMapping("/name") //http://localhost:8080/api/movie/{name}
    @ResponseStatus(value = HttpStatus.FOUND)
    public MovieDto getMovieName(@RequestParam String name) {
        Movie movie = movieService.getByName(name);
        return movieMapper.toMovieDto(movie);
    }

    @Operation(summary = "CREATE MOVIE")
    @PostMapping("/create") //http://localhost:8080/api/movie/create
    @ResponseStatus(value = HttpStatus.CREATED)
    public MovieDto createMovie(@RequestBody Movie movie) {
        Movie createMovie = movieService.create(movie);
        return movieMapper.toMovieDto(createMovie);
    }

    @PatchMapping("/update/{movieId}")
    public MovieDto updateMovie(@RequestBody Movie movie, @PathVariable("movieId") int id) {
        Movie updatedMovie = movieService.update(movie, id);
        return movieMapper.toMovieDto(updatedMovie);
    }

    @Operation(summary = "DELETE MOVIE")
    @DeleteMapping("/delete/{movieId}") //http://localhost:8080/api/movie/delete/{Id}
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteMovie(@PathVariable("movieId") int id) {
        return movieService.delete(id);
    }
}