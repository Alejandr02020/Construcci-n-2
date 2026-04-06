package com.bank.domain.ports.usecases;

import com.bank.domain.model.account.BankAccount;

public interface CreateAccountUseCase {
    void execute(BankAccount account);
}