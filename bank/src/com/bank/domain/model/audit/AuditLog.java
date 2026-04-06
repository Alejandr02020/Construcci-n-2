package com.bank.domain.model.audit;

import java.time.LocalDateTime;
import java.util.Map;

public class AuditLog {

    private String id;
    private String operationType;
    private LocalDateTime timestamp;
    private String userId;
    private String userRole;
    private String affectedEntityId;
    private Map<String, Object> details;
}