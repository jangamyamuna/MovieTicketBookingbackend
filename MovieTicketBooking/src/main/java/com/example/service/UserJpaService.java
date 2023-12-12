package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.repository.UserJpaRepository;

@Service
public class UserJpaService 
{
	@Autowired
    private UserJpaRepository userJpaRepository;

    public User userLogin(String email, String password) {
        Optional<User> user = userJpaRepository.findByEmailAndPassword(email, password);
        return user.orElse(null);
    }

    public User newUser(User user) {
        return userJpaRepository.save(user);
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        userJpaRepository.deleteByEmail(email);
    }

	

}
