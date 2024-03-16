package com.postgresql.assignment1.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_person_id", referencedColumnName = "id")
    private List<Task> tasks = new ArrayList<>();

    public Person(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
