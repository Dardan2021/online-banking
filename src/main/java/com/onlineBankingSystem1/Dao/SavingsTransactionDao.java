package com.onlineBankingSystem1.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.onlineBankingSystem1.domain.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}

