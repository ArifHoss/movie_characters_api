package com.experis.movie_characters_api.services.service_view;

import com.experis.movie_characters_api.model.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActor();

    Actor getActorById(int id);

    Actor createActor(Actor actor);

    String deleteActorById(int id);

    Actor updateActorById(Actor actor, int id);
}