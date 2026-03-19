package Model;

import java.util.Date;
import java.util.List;

public class ExpenditureRecord {
    private User user;
    private Date date;
    private int money;
    private String category;
    private String paymentMethod;
    private String remark;
    private String photoPath;

    public ExpenditureRecord(User user, Date date, int money, String category, String paymentMethod) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }
}
