package com.postgresql.assignment1.services;

import com.postgresql.assignment1.dtos.PersonDto;
import com.postgresql.assignment1.interfaces.ServiceInterface;
import com.postgresql.assignment1.mappers.PersonMapper;
import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements ServiceInterface<PersonDto> {

    @Autowired
    private PersonRepo repo;

    /*public Person savePerson(Person person) {
        return repo.save(person);
    }

    public Person updatePerson(Long id, Person person) {
        Person currentPerson = repo.findById(id).get();
        currentPerson.setLogin(person.getLogin());
        currentPerson.setPassword(person.getPassword());
        currentPerson.setEmail(person.getEmail());
        return repo.save(currentPerson);
    }



    public void deletePerson(Long id) {
        repo.deleteById(id);
    }

    public List<Person> getPeople() {
        return repo.findAll();
    }

    public Person getPerson(Long id) {
        return repo.findById(id).get();
    }*/

    public PersonDto create(PersonDto personDto) {
        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = repo.save(person);
        PersonDto savedPersonDto = PersonMapper.mapToPersonDto(savedPerson);
        return savedPersonDto;
    }

    @Override
    public PersonDto getById(Long id) {
        return PersonMapper.mapToPersonDto(repo.findById(id).get());
    }

    @Override
    public List<PersonDto> getAll() {
        return repo.findAll().stream()
                .map(PersonMapper::mapToPersonDto)
                .collect(Collectors.toList());
    }

    public PersonDto update(Long id, Map<String, Object> fields) {
        Optional<Person> currentPerson = repo.findById(id);

        if (currentPerson.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Person.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, currentPerson.get(), value);
            });

            return PersonMapper.mapToPersonDto(repo.save(currentPerson.get()));
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
