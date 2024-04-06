package com.postgresql.assignment1.controllers;

import com.postgresql.assignment1.dtos.PersonDto;
import com.postgresql.assignment1.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@Valid @RequestBody PersonDto personDto) {
        personDto.setPassword(new BCryptPasswordEncoder().encode(personDto.getPassword()));
        PersonDto savedPerson = personService.create(personDto);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getUserById(@PathVariable("id") Long id){
        PersonDto user = personService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getUsers(){
        List<PersonDto> users = personService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public PersonDto updatePerson(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return personService.update(id, fields);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>("Person successfully deleted!", HttpStatus.OK);
    }
}
