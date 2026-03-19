package Command;

import java.time.LocalDate;
import java.util.List;
import Model.User;

public class ExpenditureStatisticsCommand {
    private LocalDate date;
    private List<String> category;
    private List<String> paymentMethod;

    public ExpenditureStatisticsCommand(LocalDate date, List<String> category, List<String> paymentMethod) {
        this.date = date;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
