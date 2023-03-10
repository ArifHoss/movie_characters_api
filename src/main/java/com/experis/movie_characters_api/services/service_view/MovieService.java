package com.experis.movie_characters_api.services.service_view;

import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    Movie getById(int movieId);
    List<Actor> getActorsFromAMovie(int id);
    Movie create(Movie movie);
    String delete(int id);
    Movie update(Movie movie, int id);

    Movie updateMovieActors(List<Integer> actorsId, int id);
}
