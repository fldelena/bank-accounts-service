package com.example.aston_task_jun.bankaccount.service;

import com.example.aston_task_jun.bankaccount.entity.Account;
import com.example.aston_task_jun.bankaccount.entity.AccountCreate;
import com.example.aston_task_jun.bankaccount.entity.AccountInfo;
import com.example.aston_task_jun.bankaccount.entity.transaction.Credit;
import com.example.aston_task_jun.bankaccount.entity.transaction.Transfer;
import com.example.aston_task_jun.bankaccount.entity.transaction.Withdrawal;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createAccount(AccountCreate accountCreate);

    String topUpCredit(Credit credit);

    String withdrawMoney(Withdrawal withdrawal);

    String bankTransfer(Transfer transfer);

    List<AccountInfo> getAccounts();

}
