package com.experis.movie_characters_api.model;

import com.experis.movie_characters_api.enums.GenderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;
    @NotNull(message = "Actor first_name can't be null!")
    private String first_name;
    @NotNull(message = "Actor last_name can't be null!")
    private String last_name;
    @NotNull(message = "Actor alias can't be null!")
    private String alias;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "actor_movies",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

}
