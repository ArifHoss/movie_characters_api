package com.experis.movie_characters_api.services.service_view;

import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;

import java.util.List;
import java.util.Set;

public interface FranchiseService {
    List<Franchise> getAll();
    Franchise getById(int id);
    Set<Movie> getAllMoviesInAFranchiseById(int id);
    Franchise create(Franchise franchise);
    void delete(int id);
    Franchise update(Franchise franchise, int id);

    Franchise updateFranchiseMovies(List<Integer> moviesId, int id);
}
