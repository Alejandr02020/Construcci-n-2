package com.bank.domain.model.customer;

import java.time.LocalDate;
import java.time.Period;

public class IndividualCustomer extends Customer {

    private LocalDate birthDate;

    public boolean isAdult() {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }
}