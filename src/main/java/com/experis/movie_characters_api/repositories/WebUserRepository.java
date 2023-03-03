package com.experis.movie_characters_api.repositories;

import com.experis.movie_characters_api.model.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Integer> {

    WebUser findByName(String name);
}
