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
public class Withdrawal {
    @Size(min = 16, max = 16, message = "accountNumber must consist of 16 digits")
    @Pattern(regexp = "\\d+", message = "accountNumber must consist only of digits")
    private String accountNumber;
    @Size(min = 4, max = 4, message = "pin must consist of 4 digits")
    @Pattern(regexp = "\\d+", message = "pin must consist only of digits")
    private String pin;
    @Min(value = 0, message = "amount cannot be negative")
    private Integer amount;
}
