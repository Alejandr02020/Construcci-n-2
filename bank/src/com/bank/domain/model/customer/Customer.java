package com.bank.domain.model.customer;

import com.bank.domain.model.enums.UserStatus;

public abstract class Customer {
    protected String id;
    protected String fullName;
    protected String email;
    protected String phone;
    protected String address;
    protected UserStatus status;

    public boolean isActive() {
        return status == UserStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }
}