package com.bank.domain.ports.repositories;

import com.bank.domain.model.loan.Loan;
import java.util.Optional;

public interface LoanRepository {
    Optional<Loan> findById(Long id);
    void save(Loan loan);
}