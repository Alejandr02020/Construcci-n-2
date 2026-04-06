package com.bank.domain.ports.repositories;

import com.bank.domain.model.account.BankAccount;
import java.util.Optional;

public interface AccountRepository {
    Optional<BankAccount> findByAccountNumber(String accountNumber);
    void save(BankAccount account);
}