package com.example.aston_task_jun.bankaccount.controller;

import com.example.aston_task_jun.bankaccount.entity.transaction.Credit;
import com.example.aston_task_jun.bankaccount.entity.transaction.Transfer;
import com.example.aston_task_jun.bankaccount.entity.transaction.Withdrawal;
import com.example.aston_task_jun.bankaccount.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/credit")
    public String topUpCredit(@Valid @RequestBody Credit credit) {
        return accountService.topUpCredit(credit);
    }

    @PostMapping("/withdrawal")
    public String withdrawMoney(@Valid @RequestBody Withdrawal withdrawal) {
        return accountService.withdrawMoney(withdrawal);
    }

    @PostMapping("/transfer")
    public String bankTransfer(@Valid @RequestBody Transfer transfer) {
        return accountService.bankTransfer(transfer);
    }
}
