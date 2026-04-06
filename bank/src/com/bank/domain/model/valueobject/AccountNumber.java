package com.bank.domain.model.valueobject;

public class AccountNumber {

    private final String value;

    public AccountNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}