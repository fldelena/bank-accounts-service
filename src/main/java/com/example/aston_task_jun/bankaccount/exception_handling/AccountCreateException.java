package com.example.aston_task_jun.bankaccount.exception_handling;

public class AccountCreateException extends RuntimeException{
    public AccountCreateException() {
        super("failed to create an account");
    }
}
