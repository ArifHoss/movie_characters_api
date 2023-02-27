package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorMapperImpl implements ActorMapper {
    @Override
    public ActorDto toActorDto(Actor actor) {
        ActorDto dto = new ActorDto();
        dto.setId(actor.getId());
        dto.setFirst_name(actor.getFirst_name());
        dto.setLast_name(actor.getLast_name());
        dto.setAlias(actor.getAlias());
        dto.setGender(actor.getGender());

        if (actor.getMovies() != null) {
            List<Integer> moviesId = actor.getMovies().stream()
                    .map(Movie::getId).collect(Collectors.toList());
            dto.setMovies(moviesId);
        }

        return dto;
    }

    @Override
    public Actor toActor(ActorDto dto) {
        Actor actor = new Actor();
        actor.setId(dto.getId());
        actor.setFirst_name(dto.getFirst_name());
        actor.setLast_name(dto.getLast_name());
        actor.setAlias(dto.getAlias());
        actor.setGender(dto.getGender());
        return actor;
    }
}
