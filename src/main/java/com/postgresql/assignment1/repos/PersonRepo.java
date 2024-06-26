package com.postgresql.assignment1.repos;

import com.postgresql.assignment1.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.userdetails.UserDetails;

@RepositoryRestResource
public interface PersonRepo extends JpaRepository<Person, Long> {
    UserDetails findByLogin(String login);
}
