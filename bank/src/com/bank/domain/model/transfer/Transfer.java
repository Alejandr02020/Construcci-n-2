package com.bank.domain.model.transfer;

import com.bank.domain.model.enums.TransferStatus;
import java.math.BigDecimal;

public class Transfer {

    private Long id;
    private String sourceAccount;
    private String targetAccount;
    private BigDecimal amount;
    private TransferStatus status;
}