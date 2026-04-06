package com.bank.domain.ports.usecases;

import java.math.BigDecimal;

public interface CreateTransferUseCase {
    void execute(String sourceAccount, String targetAccount, BigDecimal amount);
}