package Model;

import java.time.LocalDate;
import java.util.List;

public class StatisticsPoint {
    private int amount;
    private User user;
    private LocalDate date;
    private List<String> sourceOfIncome;
    private List<String> paymentMethod;
    private List<String> category;

    public StatisticsPoint(int amount, User user, LocalDate date, List<String> sourceOfIncome,
            List<String> paymentMethod, List<String> category) {
        this.amount = amount;
        this.user = user;
        this.date = date;
        this.sourceOfIncome = sourceOfIncome;
        this.paymentMethod = paymentMethod;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public List<String> getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(List<String> sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    public List<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}
