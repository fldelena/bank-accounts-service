package com.example.aston_task_jun.bankaccount.entity.transaction;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
    @Size(min = 16, max = 16, message = "accountNumber must consist of 16 digits")
    @Pattern(regexp = "\\d+", message = "accountNumber must consist only of digits")
    private String accountNumber;
    @Min(value = 0, message = "amount cannot be negative")
    private Integer amount;
}
