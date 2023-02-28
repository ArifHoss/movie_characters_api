package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.model.entity.Franchise;
import com.experis.movie_characters_api.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FranchiseMapperImpl implements FranchiseMapper{
    @Override
    public FranchiseDto toFranchiseDto(Franchise franchise) {
        FranchiseDto dto = new FranchiseDto();
        dto.setId(franchise.getId());
        dto.setName(franchise.getName());
        dto.setDescription(franchise.getDescription());
        if (dto.getMovies()!=null) {
            List<Integer> movieIdSet = franchise.getMovies()
                    .stream()
                    .map(Movie::getId).collect(Collectors.toList());
            dto.setMovies(movieIdSet);
        }
        return dto;
    }

    @Override
    public Franchise toFranchise(FranchiseDto dto) {
        Franchise franchise = new Franchise();
        franchise.setId(dto.getId());
        franchise.setName(dto.getName());
        franchise.setDescription(dto.getDescription());
        return franchise;
    }
}
