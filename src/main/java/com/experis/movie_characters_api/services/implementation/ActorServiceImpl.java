package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.model.Actor;
import com.experis.movie_characters_api.repositories.ActorRepository;
import com.experis.movie_characters_api.services.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;


    public List<Actor> getAllActor() {
        return actorRepository.findAll();
    }
}
