package com.postgresql.assignment1.repos;

import com.postgresql.assignment1.models.Person;
import com.postgresql.assignment1.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepo extends JpaRepository<Task, Long> {

}
