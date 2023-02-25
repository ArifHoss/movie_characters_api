package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.ActorDto;
import com.experis.movie_characters_api.model.dto.ActorMapperImpl;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.services.implementation.ActorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorServiceImpl actorServiceImpl;
    private final ActorMapperImpl actorMapper;
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Actor> getAllActor() {
        return actorServiceImpl.getAllActor();
    }

//    @GetMapping("/{actorId}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public Actor getActorById(@PathVariable("actorId") int id) {
//        return actorServiceImpl.getActorById(id);
//    }

    @GetMapping("/{actorId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ActorDto getActorById(@PathVariable("actorId") int id) {
        return actorMapper.toActorDto(actorServiceImpl.getActorById(id));
    }

}
