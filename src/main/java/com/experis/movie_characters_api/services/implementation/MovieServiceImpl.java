package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.repositories.MovieRepository;
import com.experis.movie_characters_api.services.service_view.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getById(int movieId) {
        return getMovieById(movieId);
    }

    @Override
    public Movie getByName(String name) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie, int id) {
        return null;
    }

    @Override
    public String delete(int movieId) {
        Movie movie = getMovieById(movieId);
        movieRepository.delete(movie);
        return "Movie is deleted";
    }

    private Movie getMovieById(int movieId) {
        return movieRepository.findById(movieId).orElseThrow(() ->
                new ResourceNotFoundException("Movie with '" + movieId + " does not found."));
    }
}