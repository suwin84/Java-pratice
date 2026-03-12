import java.time.LocalDate;

public class ExpenditureQueryCommand {
    private User user;
    private LocalDate date;
    private String paymentMethod;
    private String category;

    public ExpenditureQueryCommand(User user, LocalDate date, String paymentMethod, String category) {
        this.user = user;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.category = category;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
