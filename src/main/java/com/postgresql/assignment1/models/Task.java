package com.postgresql.assignment1.models;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public Task () {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}