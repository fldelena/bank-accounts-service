package com.example.aston_task_jun.bankaccount.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountInfo{
    @Id
    private String accountNumber;
    private String name;
    private Integer balance;
}
