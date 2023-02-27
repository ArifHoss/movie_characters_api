package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.repositories.FranchiseRepository;
import com.experis.movie_characters_api.services.service_view.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;

    @Override
    public List<Franchise> getAll() {
        return null;
    }

    @Override
    public Franchise getById(int id) {
        return null;
    }

    @Override
    public Franchise getByName(String name) {
        return null;
    }

    @Override
    public Franchise create(Franchise franchise) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public Franchise update(Franchise franchise, int id) {
        return null;
    }
}
