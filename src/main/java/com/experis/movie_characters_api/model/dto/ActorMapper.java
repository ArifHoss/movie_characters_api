package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.model.entity.Actor;

public interface ActorMapper {
    ActorDto toActorDto(Actor actor);

    Actor toActor(ActorDto dto);
}
