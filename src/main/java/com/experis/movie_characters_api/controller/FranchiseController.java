package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.*;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.services.service_view.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Tag(name = "Franchise", description = "Operations related to managing franchise")
@RestController
@RequestMapping("/franchise")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;
    private final MovieMapper movieMapper;
    private final ActorMapper actorMapper;

    @Operation(summary = "GET ALL FRANCHISE")
    @GetMapping//http://localhost:8080/api/
    @ResponseStatus(value = HttpStatus.OK)
    public List<FranchiseDto> getAllFranchise() {
        List<Franchise> franchises = franchiseService.getAll();
        return franchises.stream().map(franchiseMapper::toFranchiseDto).collect(Collectors.toList());
    }

    @Operation(summary = "GET FRANCHISE BY ID")
    @GetMapping("{franchiseId}")//http://localhost:8080/api/{id}
    @ResponseStatus(value = HttpStatus.FOUND)
    public FranchiseDto getFranchiseById(@PathVariable("franchiseId") int id) {
        return franchiseMapper.toFranchiseDto(franchiseService.getById(id));
    }
    @Operation(summary = "GET MOVIES FROM A FRANCHISE")
    @GetMapping("/movies/franchiseid/{franchiseId}")//http://localhost:8080/api/movies/franchiseid/{id}
    @ResponseStatus(value = HttpStatus.FOUND)
    public List<MovieDto> getAllMoviesInAFranchiseById(@PathVariable("franchiseId") int id) {
        Set<Movie> movies = franchiseService.getAllMoviesInAFranchiseById(id);
        return movies.stream().map(movieMapper::toMovieDto).collect(Collectors.toList());
    }
    @Operation(summary = "GET ACTORS/CHARACTERS BY A FRANCHISE")
    @GetMapping("/actors/franchiseid/{franchiseId}")//http://localhost:8080/api//actors/franchiseid/{franchiseId}
    @ResponseStatus(value = HttpStatus.FOUND)
    public List<ActorDto> getAllActorsInAFranchiseById(@PathVariable("franchiseId") int id) {
        List<Actor> actors = franchiseService.getAllActorsInAFranchiseById(id);
        return actors.stream().map(actorMapper::toActorDto).collect(Collectors.toList());
    }
    @Operation(summary = "CREATE FRANCHISE")
    @PostMapping("/create")//http://localhost:8080/api/create
    @ResponseStatus(value = HttpStatus.CREATED)
    public FranchiseDto createFranchise(@RequestBody Franchise franchise) {
        Franchise createFranchise = franchiseService.create(franchise);
        return franchiseMapper.toFranchiseDto(createFranchise);
    }
    @Operation(summary = "DELETE FRANCHISE BY ID")
    @DeleteMapping("/delete/{franchiseId}")//http://localhost:8080/api/delete/{franchiseId}
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteFranchise(@PathVariable("franchiseId") int id) {
        franchiseService.delete(id);
        return "Deleted franchise.";
    }

    @Operation(summary = "UPDATE FRANCHISE")
    @PatchMapping("/update/{franchiseId}")//http://localhost:8080/api/update/{franchiseId}
    @ResponseStatus(value = HttpStatus.OK)
    public FranchiseDto updateFranchise(@RequestBody Franchise franchise, @PathVariable("franchiseId") int id) {
        return franchiseMapper.toFranchiseDto(franchiseService.update(franchise, id));
    }

    @Operation(summary = "GET ALL MOVIES IN A FRANCHISE")
    @PatchMapping("/update/movies/{franchiseId}")//http://localhost:8080/api//update/movies/{franchiseId}
    @ResponseStatus(value = HttpStatus.OK)
    public FranchiseDto updateFranchiseMovies(@RequestBody List<Integer> moviesId, @PathVariable("franchiseId") int id) {
        return franchiseMapper.toFranchiseDto(franchiseService.updateFranchiseMovies(moviesId, id));
    }
}
