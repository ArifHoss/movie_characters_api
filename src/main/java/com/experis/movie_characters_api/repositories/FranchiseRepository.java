package com.experis.movie_characters_api.repositories;

import com.experis.movie_characters_api.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

}
