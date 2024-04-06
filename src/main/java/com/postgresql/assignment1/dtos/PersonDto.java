package com.postgresql.assignment1.dtos;

import com.postgresql.assignment1.enums.PersonRole;
import com.postgresql.assignment1.interfaces.ContainsLettersNumbersSpecialChars;
import com.postgresql.assignment1.models.Task;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String login;

    @ContainsLettersNumbersSpecialChars
    private String password;
    private String email;
    private PersonRole role;
    private List<Task> tasks;
}
