package com.bank.domain.model.loan;

import com.bank.domain.model.enums.LoanStatus;
import java.math.BigDecimal;

public class Loan {

    private Long id;
    private String customerId;
    private BigDecimal approvedAmount;
    private LoanStatus status;
    private String targetAccount;

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }
}