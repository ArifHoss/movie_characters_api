package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.Actor;
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
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Actor> getAllActor() {
        return actorServiceImpl.getAllActor();
    }

    @GetMapping("/{actorId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Actor getActorById(@PathVariable("actorId") int id) {
        return actorServiceImpl.getActorById(id);
    }

}
