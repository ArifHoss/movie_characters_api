package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.repositories.FranchiseRepository;
import com.experis.movie_characters_api.repositories.MovieRepository;
import com.experis.movie_characters_api.services.service_view.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Franchise getByName(String name) {
        return null;
    }

    @Override
    public Franchise create(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public void delete(int id) {
        Franchise franchise = getFranchiseById(id);
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

    @Override
    public Franchise updateFranchiseMovies(List<Integer> moviesId, int id) {
        //Updating movies in a franchise.
        //This can take in an integer array of movie Id’s in the body, and an Franchise Id in the path.
        Franchise franchise = getFranchiseById(id);
        Set<Movie> existingMovies = franchise.getMovies();

        Set<Movie> newMovies = new HashSet<>(movieRepository.findAllById(moviesId));


        for (Movie movie : existingMovies) {
            movie.setFranchise(null);
            movieRepository.save(movie);
        }

        for (Movie movie : newMovies) {
            movie.getFranchise().setMovies(newMovies);
            movieRepository.save(movie);
        }
        franchise.setMovies(newMovies);
        franchiseRepository.save(franchise);
        return franchise;
    }

    private Franchise getFranchiseById(int id) {
        return franchiseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("There is no franchise with this id '" + id + "'"));
    }
}
