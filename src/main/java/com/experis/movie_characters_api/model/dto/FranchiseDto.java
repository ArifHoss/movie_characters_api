package com.experis.movie_characters_api.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class FranchiseDto {
    private int id;
    private String name;
    private String description;
    private Set<Integer> movies;
}
