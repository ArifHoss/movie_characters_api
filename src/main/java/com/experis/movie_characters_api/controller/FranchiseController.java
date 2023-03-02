package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.dto.*;
import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;
import com.experis.movie_characters_api.services.service_view.FranchiseService;
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


    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<FranchiseDto> getAllFranchise() {
        List<Franchise> franchises = franchiseService.getAll();
        return franchises.stream().map(franchiseMapper::toFranchiseDto).collect(Collectors.toList());
    }

    @GetMapping("{franchiseId}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public FranchiseDto getFranchiseById(@PathVariable("franchiseId") int id) {
        return franchiseMapper.toFranchiseDto(franchiseService.getById(id));
    }

    @GetMapping("/movies/franchiseid/{franchiseId}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public List<MovieDto> getAllMoviesInAFranchiseById(@PathVariable("franchiseId") int id) {
        Set<Movie> movies = franchiseService.getAllMoviesInAFranchiseById(id);
        return movies.stream().map(movieMapper::toMovieDto).collect(Collectors.toList());
    }

    @GetMapping("/actors/franchiseid/{franchiseId}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public List<ActorDto> getAllActorsInAFranchiseById(@PathVariable("franchiseId") int id) {
        List<Actor> actors = franchiseService.getAllActorsInAFranchiseById(id);
        return actors.stream().map(actorMapper::toActorDto).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public FranchiseDto createFranchise(@RequestBody Franchise franchise) {
        Franchise createFranchise = franchiseService.create(franchise);
        return franchiseMapper.toFranchiseDto(createFranchise);
    }

    @DeleteMapping("/delete/{franchiseId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteFranchise(@PathVariable("franchiseId") int id) {
        franchiseService.delete(id);
        return "Deleted franchise.";
    }

    @PatchMapping("/update/{franchiseId}")
    @ResponseStatus(value = HttpStatus.OK)
    public FranchiseDto updateFranchise(@RequestBody Franchise franchise, @PathVariable("franchiseId") int id) {
        return franchiseMapper.toFranchiseDto(franchiseService.update(franchise, id));
    }


    @PatchMapping("/update/movies/{franchiseId}")
    @ResponseStatus(value = HttpStatus.OK)
    public FranchiseDto updateFranchiseMovies(@RequestBody List<Integer> moviesId, @PathVariable("franchiseId") int id) {
        return franchiseMapper.toFranchiseDto(franchiseService.updateFranchiseMovies(moviesId, id));
    }
}
