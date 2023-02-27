package com.experis.movie_characters_api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Franchise", description = "Operations related to managing franchise")
@RestController
@RequestMapping("/franchise")
public class FranchiseController {

}
