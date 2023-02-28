package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.repositories.MovieRepository;
import com.experis.movie_characters_api.services.service_view.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

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
        Movie movieToUpdate = getMovieById(id);

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setRelease_year(movie.getRelease_year());
        movieToUpdate.setDirector_name(movie.getDirector_name());
        movieToUpdate.setMovie_poster(movie.getMovie_poster());
        movieToUpdate.setMovie_trailer(movie.getMovie_trailer());

        movieRepository.save(movieToUpdate);
        return movieToUpdate;
    }

    @Override
    public Movie updateActors(List<Integer> actorsId, int id) {
        Movie movie = getMovieById(id);
        // old actor id list
        List<Integer> actorIdList = movie.getActors().stream().map(Actor::getId).collect(Collectors.toList());
        // new actor id list 'actorsID'
        actorIdList.replaceAll((UnaryOperator<Integer>) actorsId);

//        actorsId.stream().map(integer -> actorIdList.)
//        movie.setActors();
        movieRepository.save(movie);
        return movie;
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