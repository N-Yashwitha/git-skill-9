package com.klef.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.model.User;
import com.klef.repository.UserRepository;

@Service

public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {

        return repo.save(user);

    }

    public Optional<User> login(
            String username,
            String password) {

        Optional<User> user =
            repo.findByUsername(username);

        if(user.isPresent() &&
           user.get().getPassword()
           .equals(password)) {

            return user;

        }

        return Optional.empty();
    }

    public Optional<User> getProfile(
            String username) {

        return repo.findByUsername(username);

    }
}