package com.experis.movie_characters_api.services.service_view;

import com.experis.movie_characters_api.model.entity.Franchise;

import java.util.List;

public interface FranchiseService {
    List<Franchise> getAll();
    Franchise getById(int id);
    Franchise getByName(String name);
    Franchise create(Franchise franchise);
    void delete(int id);
    Franchise update(Franchise franchise, int id);
}
