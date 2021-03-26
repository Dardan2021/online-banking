package com.onlineBankingSystem1.service;



import java.security.Principal;

import com.onlineBankingSystem1.domain.PrimaryAccount;

import com.onlineBankingSystem1.domain.SavingsAccount;


public interface AccountService {
PrimaryAccount createPrimaryAccount();
SavingsAccount createSavingsAccount();
void deposit(String accountType, double amount, Principal principal);
void withdraw(String accountType, double amount, Principal principal);

}

 