package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ConflictException;
import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.repositories.ActorRepository;
import com.experis.movie_characters_api.repositories.MovieRepository;
import com.experis.movie_characters_api.services.service_view.MovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

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

    @Transactional
    @Override
    public Movie updateActors(List<Integer> actorsId, int id) { // God function
        Movie movie = getMovieById(id);


        Set<Actor> newActors = new HashSet<>(actorRepository.findAllById(actorsId));
        Set<Actor> existingActors = movie.getActors();
        if (actorsId.size() != newActors.size()) {
            throw new ConflictException("You can not add to same character!");
        }
        if (newActors.containsAll(existingActors) || newActors.stream().anyMatch(actor -> newActors.stream().anyMatch(old -> actor != old))) {
            throw new ConflictException("Do not do it!Last warning!");
        }


        for (Actor actor : existingActors) {
            actor.setMovies(null);
            actorRepository.save(actor);
        }
        for (Actor actor : newActors) {
            actor.getMovies().add(movie);
            actorRepository.save(actor);
        }
        movie.setActors(newActors);
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