package com.example.aston_task_jun.bankaccount.controller;


import com.example.aston_task_jun.bankaccount.entity.Account;
import com.example.aston_task_jun.bankaccount.entity.AccountCreate;
import com.example.aston_task_jun.bankaccount.entity.AccountInfo;
import com.example.aston_task_jun.bankaccount.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@Valid @RequestBody AccountCreate accountCreate) {
        return accountService.createAccount(accountCreate);
    }

    @GetMapping("/getAll")
    public List<AccountInfo> getAccounts() {
        return accountService.getAccounts();
    }
}
