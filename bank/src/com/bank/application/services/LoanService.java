package com.bank.application.services;

import com.bank.domain.model.loan.Loan;
import com.bank.domain.model.account.BankAccount;
import com.bank.domain.ports.repositories.LoanRepository;
import com.bank.domain.ports.repositories.AccountRepository;
import com.bank.domain.ports.repositories.AuditLogRepository;
import com.bank.domain.ports.usecases.ApproveLoanUseCase;
import com.bank.domain.ports.usecases.DisburseLoanUseCase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanService implements ApproveLoanUseCase, DisburseLoanUseCase {

    private final LoanRepository loanRepository;
    private final AccountRepository accountRepository;
    private final AuditLogRepository auditLogRepository;

    public LoanService(LoanRepository loanRepository,
                       AccountRepository accountRepository,
                       AuditLogRepository auditLogRepository) {
        this.loanRepository = loanRepository;
        this.accountRepository = accountRepository;
        this.auditLogRepository = auditLogRepository;
    }

    // Aprobar préstamo
    @Override
    public void execute(Long loanId, BigDecimal approvedAmount) {

        if (approvedAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid approved amount");
        }

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.approve(approvedAmount);

        loanRepository.save(loan);
        auditLogRepository.save("Loan approved at " + LocalDateTime.now());
    }

    // Desembolsar préstamo
    @Override
    public void execute(Long loanId) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        BankAccount account = accountRepository
                .findByAccountNumber(loan.getTargetAccount())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // Impacto financiero
        account.credit(loan.getApprovedAmount());
        loan.disburse();

        accountRepository.save(account);
        loanRepository.save(loan);

        auditLogRepository.save("Loan disbursed at " + LocalDateTime.now());
    }
}