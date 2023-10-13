package com.example.aston_task_jun.bankaccount.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreate {
    @NotBlank(message = "field cannot be empty")
    private String name;
    @Size(min = 4, max = 4, message = "pin must consist of 4 digits")
    @Pattern(regexp = "\\d+", message = "pin must consist only of digits")
    private String pin;
}
