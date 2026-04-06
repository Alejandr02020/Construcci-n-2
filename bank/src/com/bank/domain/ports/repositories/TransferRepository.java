package com.bank.domain.ports.repositories;

import com.bank.domain.model.transfer.Transfer;
import java.util.Optional;

public interface TransferRepository {
    Optional<Transfer> findById(Long id);
    void save(Transfer transfer);
}
