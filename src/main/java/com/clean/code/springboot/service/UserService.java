package com.clean.code.springboot.service;


import com.clean.code.springboot.domain.User;
import com.clean.code.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        return userRepository.findById(id).get();

    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();

    }




}
