package com.experis.movie_characters_api.services.service_view;


import com.experis.movie_characters_api.model.entity.WebUser;

public interface UserService {
    WebUser fineUserByName(String name);
}
