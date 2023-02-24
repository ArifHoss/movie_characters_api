package com.experis.movie_characters_api.repositories;

import com.experis.movie_characters_api.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

}
