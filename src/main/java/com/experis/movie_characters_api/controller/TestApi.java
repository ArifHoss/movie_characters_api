package com.experis.movie_characters_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {

    @GetMapping
    public String getMessage() {
        return "Hello from Arif and Zakhida :) ";
    }

}
