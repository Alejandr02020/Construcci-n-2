package com.bank.application.services;

import com.bank.domain.model.account.BankAccount;
import com.bank.domain.model.transfer.Transfer;
import com.bank.domain.ports.repositories.AccountRepository;
import com.bank.domain.ports.repositories.TransferRepository;
import com.bank.domain.ports.repositories.AuditLogRepository;
import com.bank.domain.ports.usecases.CreateTransferUseCase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferService implements CreateTransferUseCase {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    private final AuditLogRepository auditLogRepository;

    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository,
                           AuditLogRepository auditLogRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public void execute(String source, String target, BigDecimal amount) {

        // Validación básica
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        BankAccount sourceAccount = accountRepository
                .findByAccountNumber(source)
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        BankAccount targetAccount = accountRepository
                .findByAccountNumber(target)
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        // Reglas de negocio
        sourceAccount.debit(amount);
        targetAccount.credit(amount);

        // Crear transferencia
        Transfer transfer = new Transfer();
        transfer.execute();

        // Persistencia
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
        transferRepository.save(transfer);

        // Bitácora
        auditLogRepository.save("Transfer executed at " + LocalDateTime.now());
    }
}