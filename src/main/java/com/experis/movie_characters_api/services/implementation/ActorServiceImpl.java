package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.repositories.ActorRepository;
import com.experis.movie_characters_api.services.service_view.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getById(int id) {
        return findById(id);
    }

    @Override
    public Actor getByName(String name) {
        return null;
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public String delete(int id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
        return "Actor is deleted";
    }

    @Override
    public Actor update(Actor actor, int id) {
        Actor actorToUpdate = findById(id);

        // We need to read input
        //

        return null;
    }

    private Actor findById(int id) {
        return actorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Actor with this id '" + id + "', does not exist."));
    }
}
