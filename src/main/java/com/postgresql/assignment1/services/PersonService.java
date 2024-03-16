package com.postgresql.assignment1.services;

import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public Person savePerson(Person person) {
        return repo.save(person);
    }

    public Person updatePerson(Long id, Person person) {
        Person currentPerson = repo.findById(id).get();
        currentPerson.setName(person.getName());
        currentPerson.setPassword(person.getPassword());
        currentPerson.setEmail(person.getEmail());
        return repo.save(currentPerson);
    }

    public Person updatePersonBetter(Long id, Map<String, Object> fields) {
        Optional<Person> currentPerson = repo.findById(id);

        if (currentPerson.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Person.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, currentPerson.get(), value);
            });

            return repo.save(currentPerson.get());
        }
        return null;
    }

    public void deletePerson(Long id) {
        repo.deleteById(id);
    }

    public List<Person> getPeople() {
        return repo.findAll();
    }

    public Person getPerson(Long id) {
        return repo.findById(id).get();
    }

}
