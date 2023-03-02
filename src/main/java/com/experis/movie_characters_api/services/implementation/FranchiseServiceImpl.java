package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ConflictException;
import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.repositories.FranchiseRepository;
import com.experis.movie_characters_api.repositories.MovieRepository;
import com.experis.movie_characters_api.services.service_view.FranchiseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;

    @Override
    public List<Franchise> getAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise getById(int id) {
        return getFranchiseById(id);
    }

    @Override
    public Set<Movie> getAllMoviesInAFranchiseById(int id) {

        Franchise franchiseById = getFranchiseById(id);
        Set<Movie> movies = franchiseById.getMovies();
        return movies;
    }

    @Override
    public Franchise create(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public void delete(int id) {
        Franchise franchise = getFranchiseById(id);
        Set<Movie> movies = franchise.getMovies();
        for (Movie movie : movies) {
            movie.setFranchise(null);
        }
        franchiseRepository.delete(franchise);
    }

    @Override
    public Franchise update(Franchise franchise, int id) {
        Franchise findFranchiseToUpdate = getFranchiseById(id);
        findFranchiseToUpdate.setName(franchise.getName());
        findFranchiseToUpdate.setDescription(franchise.getDescription());
        franchiseRepository.save(findFranchiseToUpdate);
        return findFranchiseToUpdate;
    }

    @Transactional
    @Override
    public Franchise updateFranchiseMovies(List<Integer> moviesId, int id) {
        Franchise franchise = getFranchiseById(id);
        Set<Movie> newMovies = new HashSet<>(movieRepository.findAllById(moviesId));
        Set<Movie> existingMovies = franchise.getMovies();

        if (moviesId.size() != newMovies.size()) {
            throw new ConflictException("You can not add same movie");
        }

//        boolean hasDuplicateMovies = newMovies.stream().anyMatch(movie -> newMovies.stream().anyMatch(movie1 -> movie != movie1));
//
//        if (newMovies.containsAll(existingMovies) || hasDuplicateMovies) {
//            throw new ConflictException("You can not add same movie");
//        }

        for (Movie movie : existingMovies) {
            movie.setFranchise(null);
            movieRepository.save(movie);
        }

        for (Movie movie : newMovies) {
            movie.setFranchise(franchise);
            movieRepository.save(movie);
        }
        franchise.setMovies(newMovies);
        franchiseRepository.save(franchise);
        return franchise;
    }

    @Override
    public List<Actor> getAllActorsInAFranchiseById(int id) {
        Franchise franchise = getFranchiseById(id);
        Set<Movie> movies = franchise.getMovies();
        Set<Actor> actors = new HashSet<>();
        for (Movie movie : movies) {
            actors.addAll(movie.getActors());
        }
        return new ArrayList<>(actors);
    }

    private Franchise getFranchiseById(int id) {
        return franchiseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("There is no franchise with this id '" + id + "'"));
    }
}
