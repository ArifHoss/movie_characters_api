package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.exception.ResourceNotFoundException;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.repositories.ActorRepository;
import com.experis.movie_characters_api.services.service_view.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public String delete(int id) {
        Actor actor = findById(id);
        Set<Movie> movies = actor.getMovies();

        for (Movie movie : movies) {
            movie.setActors(null);
        }

        actorRepository.delete(actor);
        return "Actor is deleted";
    }

    @Override
    public Actor update(Actor actor, int id) {
        Actor actorToUpdate = findById(id);
        actorToUpdate.setFirst_name(actor.getFirst_name());
        actorToUpdate.setLast_name(actor.getLast_name());
        actorToUpdate.setAlias(actor.getAlias());
        actorToUpdate.setGender(actor.getGender());
        return actorRepository.save(actorToUpdate);
    }

    private Actor findById(int id) {
        return actorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Actor with this id '" + id + "', does not exist."));
    }
}
