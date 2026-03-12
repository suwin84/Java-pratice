package com.example;

import java.time.LocalDate;
import java.util.List;

public class IncomeRecord {
    private User user;
    private LocalDate date;
    private int money;
    private List<String> sourceOfIncome;

    public IncomeRecord(User user, LocalDate date, int money, List<String> sourceOfIncome) {
        this.user = user;
        this.date = date;
        this.money = money;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<String> getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(List<String> sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }
}
