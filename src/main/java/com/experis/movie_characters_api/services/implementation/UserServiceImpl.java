package com.experis.movie_characters_api.services.implementation;

import com.experis.movie_characters_api.model.entity.WebUser;
import com.experis.movie_characters_api.repositories.WebUserRepository;
import com.experis.movie_characters_api.services.service_view.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final WebUserRepository userRepository;
    @Override
    public WebUser fineUserByName(String name) {
        return userRepository.findByName(name);
    }
}
