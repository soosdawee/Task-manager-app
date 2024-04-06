package com.postgresql.assignment1.models;

import com.postgresql.assignment1.interfaces.ContainsLettersNumbersSpecialChars;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.postgresql.assignment1.enums.PersonRole;

@Data
@Entity
@Table(name = "person")
public class Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 5, message = "Your name should be at least 5 characters long!")
    private String login;


    private String password;

    @Column(unique = true)
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_person_id", referencedColumnName = "id")
    private List<Task> tasks = new ArrayList<>();

    public Person(String login, String password, String email, PersonRole role, List<Task> tasks) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.tasks = tasks;
    }

    public Person(String login, String password, String email, PersonRole role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == PersonRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
