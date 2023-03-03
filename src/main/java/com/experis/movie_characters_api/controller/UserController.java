package com.experis.movie_characters_api.controller;

import com.experis.movie_characters_api.model.entity.WebUser;
import com.experis.movie_characters_api.services.service_view.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "Operations related to managing user")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping
    public WebUser findUserByName(String name) {
        return userService.fineUserByName(name);
    }
}
