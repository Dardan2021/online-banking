package com.onlineBankingSystem1.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.onlineBankingSystem1.domain.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
