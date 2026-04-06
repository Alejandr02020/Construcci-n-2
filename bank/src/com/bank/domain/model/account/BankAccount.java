package com.bank.domain.model.account;

import com.bank.domain.model.enums.AccountStatus;
import com.bank.domain.model.enums.AccountType;

import java.math.BigDecimal;

public class BankAccount {

    private String accountNumber;
    private AccountType accountType;
    private String ownerId;
    private BigDecimal balance;
    private AccountStatus status;

    public void debit(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}