package com.bank.domain.ports.usecases;

import java.math.BigDecimal;

public interface ApproveLoanUseCase {
    void execute(Long loanId, BigDecimal approvedAmount);
}