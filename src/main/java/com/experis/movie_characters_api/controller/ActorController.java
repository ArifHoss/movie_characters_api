package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.Actor;
import com.experis.movie_characters_api.services.ActorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorServiceImpl actorServiceImpl;
    @GetMapping
    public List<Actor> getAllActor() {
        return actorServiceImpl.getAllActor();
    }

}
