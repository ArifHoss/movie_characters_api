package com.experis.movie_characters_api.services;

import com.experis.movie_characters_api.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl {
    private final ActorRepository actorRepository;


}
