package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.model.entity.Franchise;

public interface FranchiseMapper {

    FranchiseDto toFranchiseDto(Franchise franchise);

    Franchise toFranchise(FranchiseDto dto);
}
