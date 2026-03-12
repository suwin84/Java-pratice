package com.example;

import java.time.LocalDate;

public class IncomeQueryCommand {
    private User user;
    private LocalDate date;
    private String sourceOfIncome;

    public IncomeQueryCommand(User user, LocalDate date, String sourceOfIncome) {
        this.user = user;
        this.date = date;
        this.sourceOfIncome = sourceOfIncome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }
}
