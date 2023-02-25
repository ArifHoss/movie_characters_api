package com.experis.movie_characters_api.services.service_view;

import com.experis.movie_characters_api.model.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActor();

    Actor getActorById(int id);
}
