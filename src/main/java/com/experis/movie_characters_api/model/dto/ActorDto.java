package com.experis.movie_characters_api.model.dto;

import com.experis.movie_characters_api.enums.GenderType;
import lombok.Data;

import java.util.List;

@Data
public class ActorDto {

    private int id;
    private String first_name;
    private String last_name;
    private String alias;
    private GenderType gender;
    private List<Integer> movies;
}
