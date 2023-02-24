package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.repositories.MovieRepository;
import com.experis.movie_characters_api.services.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
}
