package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.model.entity.Actor;
import com.experis.movie_characters_api.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieDto toMovieDto(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setGenre(movie.getGenre());
        dto.setRelease_year(movie.getRelease_year());
        dto.setDirector_name(movie.getDirector_name());
        dto.setMovie_poster(movie.getMovie_poster());
        dto.setMovie_trailer(movie.getMovie_trailer());

        if (movie.getActors() != null) {
            List<Integer> actorsId = movie.getActors()
                    .stream()
                    .map(Actor::getId).collect(Collectors.toList());
            dto.setActors(actorsId);
        }

        if (movie.getFranchise() != null) {
            dto.setFranchise(movie.getFranchise().getId());
        }

        return dto;
    }

    @Override
    public Movie toMovie(MovieDto dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setGenre(dto.getGenre());
        movie.setRelease_year(dto.getRelease_year());
        movie.setDirector_name(dto.getDirector_name());
        movie.setMovie_poster(dto.getMovie_poster());
        movie.setMovie_trailer(dto.getMovie_trailer());
        return movie;
    }
}
