package com.bank.application.services;

import com.bank.domain.model.account.BankAccount;
import com.bank.domain.ports.repositories.AccountRepository;
import com.bank.domain.ports.usecases.CreateAccountUseCase;

public class AccountService implements CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void execute(BankAccount account) {

        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }

        accountRepository.save(account);
    }
}