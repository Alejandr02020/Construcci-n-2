package com.bank.domain.ports.repositories;

public interface AuditLogRepository {
    void save(Object event);
}
