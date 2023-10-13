package com.example.aston_task_jun.bankaccount.service.impl;

import com.example.aston_task_jun.bankaccount.dao.AccountInfoRepository;
import com.example.aston_task_jun.bankaccount.dao.AccountRepository;
import com.example.aston_task_jun.bankaccount.entity.Account;
import com.example.aston_task_jun.bankaccount.entity.AccountCreate;
import com.example.aston_task_jun.bankaccount.entity.AccountInfo;
import com.example.aston_task_jun.bankaccount.entity.transaction.Credit;
import com.example.aston_task_jun.bankaccount.entity.transaction.Transfer;
import com.example.aston_task_jun.bankaccount.entity.transaction.Withdrawal;
import com.example.aston_task_jun.bankaccount.exception_handling.NoSuchAccountException;
import com.example.aston_task_jun.bankaccount.exception_handling.TransactionException;
import com.example.aston_task_jun.bankaccount.service.AccountService;
import com.example.aston_task_jun.bankaccount.utils.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountInfoRepository accountInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(AccountCreate accountCreate) {
        Account account = new Account();
        account.setName(accountCreate.getName());
        account.setAccountNumber(AccountUtil.getRandomNumberBetweenRange());
        account.setPin(passwordEncoder.encode(accountCreate.getPin()));
        account.setBalance(0);
        return accountRepository.save(account);
    }

    public String topUpCredit(Credit credit) {
        Account account = accountRepository.findByAccountNumber(credit.getAccountNumber());
        if (account == null) {
            throw new NoSuchAccountException("there is no account with the number "
                    + credit.getAccountNumber());
        }
        account.setBalance(account.getBalance() + credit.getAmount());
        accountRepository.save(account);
        return "The operation was successful! Current balance: " + account.getBalance();
    }

    public String withdrawMoney(Withdrawal withdrawal) {
        Account account = accountRepository.findByAccountNumber(withdrawal.getAccountNumber());
        if (account == null) {
            throw new NoSuchAccountException("there is no account with the number "
                    + withdrawal.getAccountNumber());
        }
        if (passwordEncoder.matches(withdrawal.getPin(), account.getPin())) {
            if (account.getBalance() >= withdrawal.getAmount()) {
                account.setBalance(account.getBalance() - withdrawal.getAmount());
                accountRepository.save(account);
            } else {
                throw new TransactionException("insufficient funds");
            }
        } else {
            throw new TransactionException("invalid pin");
        }
        return "The operation was successful! Current balance: " + account.getBalance();
    }

    public String bankTransfer(Transfer transfer) {
        Account fromAccount = accountRepository.findByAccountNumber(transfer.getFromAccountNumber());
        Account toAccount = accountRepository.findByAccountNumber(transfer.getToAccountNumber());
        if (fromAccount == null) {
            throw new NoSuchAccountException("there is no account with the number "
                    + transfer.getFromAccountNumber());
        }
        if (toAccount == null) {
            throw new NoSuchAccountException("there is no account with the number "
                    + transfer.getToAccountNumber());
        }
        if (passwordEncoder.matches(transfer.getPin(), fromAccount.getPin())) {
            if (fromAccount.getBalance() >= transfer.getAmount()) {
                fromAccount.setBalance(fromAccount.getBalance() - transfer.getAmount());
                toAccount.setBalance(toAccount.getBalance() + transfer.getAmount());
                accountRepository.save(fromAccount);
                accountRepository.save(toAccount);
            } else {
                throw new TransactionException("insufficient funds");
            }
        } else {
            throw new TransactionException("invalid pin");
        }
        return "The operation was successful! Current balance: " + fromAccount.getBalance();
    }

    public List<AccountInfo> getAccounts() {
        return accountInfoRepository.findAll();
    }
}
