package com.experis.movie_characters_api.services;

import com.experis.movie_characters_api.repositories.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService{
    private final FranchiseRepository franchiseRepository;
}
