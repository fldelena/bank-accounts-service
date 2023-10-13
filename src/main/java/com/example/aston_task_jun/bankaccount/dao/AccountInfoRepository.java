package com.example.aston_task_jun.bankaccount.dao;

import com.example.aston_task_jun.bankaccount.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, String> {

    @Query(value = "SELECT account_number, name, balance FROM Account", nativeQuery = true)
    List<AccountInfo> findAll();
}
