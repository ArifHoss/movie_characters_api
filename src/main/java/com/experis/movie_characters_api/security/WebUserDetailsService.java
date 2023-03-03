//package com.experis.movie_characters_api.security;
//
//import com.experis.movie_characters_api.model.entity.WebUser;
//import com.experis.movie_characters_api.repositories.WebUserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class WebUserDetailsService implements UserDetailsService {
//
//    private  final WebUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        WebUser user = userRepository.findByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return User.withUsername(user.getName())
//                .password(user.getPassword())
//                .roles(user.getRole())
//                .build();
//    }
//}
//
