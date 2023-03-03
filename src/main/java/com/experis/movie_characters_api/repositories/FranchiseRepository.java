package com.experis.movie_characters_api.repositories;

import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

//    Optional<Set<Movie>> findFranchiseByMovies(Integer id);

    //Optional<Set<Character>> findByMoviesFranchiseId(Integer id);

}
