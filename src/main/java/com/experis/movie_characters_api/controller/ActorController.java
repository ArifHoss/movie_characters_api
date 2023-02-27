package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.ActorDto;
import com.experis.movie_characters_api.model.dto.ActorMapper;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.services.service_view.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "Characters", description = "Operations related to managing movie characters")
@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final ActorMapper actorMapper;

    @Operation(summary = "GET ALL ACTORS")
    @GetMapping //http://localhost:8080/api/actor
    @ResponseStatus(value = HttpStatus.OK)
    public List<ActorDto> getAllActor() {
        // Retrieves all actors from the database and mapps them to a list of 'ActorDto' objects using 'ActorMapper' class.
        List<Actor> actorList = actorService.getAllActor();
        return actorList.stream()
                .map(actorMapper::toActorDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "GET ACTOR BY ID")
    @GetMapping("/{actorId}") //http://localhost:8080/api/actor/{id}
    @ResponseStatus(value = HttpStatus.OK)
    public ActorDto getActorById(@PathVariable("actorId") int id) {
        return actorMapper.toActorDto(actorService.getActorById(id));
    }

    @Operation(summary = "CREATE ACTOR")
    @PostMapping("/create")//http://localhost:8080/api/actor/create
    @ResponseStatus(value = HttpStatus.CREATED)
    public ActorDto createActor(@RequestBody Actor actor) {
        return actorMapper.toActorDto(actorService.createActor(actor));
    }

    @Operation(summary = "UPDATE ACTOR")
    @PatchMapping("/update") //http://localhost:8080/api/actor/update/{actorId}
    @ResponseStatus(value = HttpStatus.OK)
    public ActorDto updateActorById(@RequestBody Actor actor, @PathVariable("actorId") int id) {
        return actorMapper.toActorDto(actorService.updateActorById(actor, id));
    }


    @Operation(summary = "DELETE ACTOR")
    @DeleteMapping("/delete/{actorId}") //http://localhost:8080/api/actor/delete/{actorId}
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteActorById(@PathVariable("actorId") int id) {
        return actorService.deleteActorById(id);
    }
}






















