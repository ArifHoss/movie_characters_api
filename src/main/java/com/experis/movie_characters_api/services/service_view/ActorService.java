package com.experis.movie_characters_api.services.service_view;

import com.experis.movie_characters_api.model.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAll();

    Actor getById(int id);

    Actor create(Actor actor);

    String delete(int id);

    Actor update(Actor actor, int id);
}
