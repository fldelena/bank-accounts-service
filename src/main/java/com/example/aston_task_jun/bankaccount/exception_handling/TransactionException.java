package com.example.aston_task_jun.bankaccount.exception_handling;

public class TransactionException extends RuntimeException{
    public TransactionException(String message) {
        super(message);
    }
}
