package com.experis.movie_characters_api.repositories;

import com.experis.movie_characters_api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
