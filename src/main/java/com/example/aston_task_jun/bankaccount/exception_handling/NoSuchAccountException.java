package com.example.aston_task_jun.bankaccount.exception_handling;

public class NoSuchAccountException extends RuntimeException{

    public NoSuchAccountException(String message) {
        super(message);
    }
}
