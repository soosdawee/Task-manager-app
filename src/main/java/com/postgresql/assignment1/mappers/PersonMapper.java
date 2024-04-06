package com.postgresql.assignment1.mappers;

import com.postgresql.assignment1.dtos.PersonDto;
import com.postgresql.assignment1.dtos.TaskDto;
import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.models.Task;

public class PersonMapper {
    public static PersonDto mapToPersonDto(Person person){
        PersonDto personDto = new PersonDto(
                person.getId(),
                person.getLogin(),
                person.getPassword(),
                person.getEmail(),
                person.getRole(),
                person.getTasks()
        );
        return personDto;
    }

    public static Person mapToPerson(PersonDto personDto){
        Person person = new Person(
                personDto.getLogin(),
                personDto.getPassword(),
                personDto.getEmail(),
                personDto.getRole(),
                personDto.getTasks()
        );
        return person;
    }
}
