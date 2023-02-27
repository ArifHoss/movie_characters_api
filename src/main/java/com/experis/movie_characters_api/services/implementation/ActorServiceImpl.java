package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.repositories.ActorRepository;
import com.experis.movie_characters_api.services.service_view.ActorService;
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

    @Override
    public Actor getActorById(int id) {
        return actorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Actor with this '"+id+", does not exist."));
    }

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
