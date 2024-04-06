package com.postgresql.assignment1.services;

import com.postgresql.assignment1.dtos.SignUpDto;
import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    PersonRepo repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByLogin(username);
        return user;
    }

    public UserDetails signUp(SignUpDto data) throws Exception {
        if (repository.findByLogin(data.login()) != null) {
            throw new Exception("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Person newUser = new Person(data.login(), encryptedPassword, data.email() ,data.role());
        return repository.save(newUser);
    }
}