import java.util.Date;
import java.util.List;

public class ExpenditureRecord {
    private User user;
    private Date date;
    private int money;
    private List<String> category;
    private List<String> paymentMethod;

    public ExpenditureRecord(User user, Date date, int money, List<String> category, List<String> paymentMethod) {
        this.user = user;
        this.date = date;
        this.money = money;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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
