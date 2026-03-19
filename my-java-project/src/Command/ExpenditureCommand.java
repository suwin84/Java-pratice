package Command;

import java.io.File;
import Model.User;

public class ExpenditureCommand {
    private Integer money;
    private User user;
    private String category;
    private String paymentMethod;
    private String remark;
    private String photoPath;
    private File photo;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        if (money == null) {
            throw new IllegalArgumentException("金額不可為空");
        }
        if (money < 0) {
            throw new IllegalArgumentException("金額不可為負數");
        }
        this.money = money;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("消費類別不可為空");
        }
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("付款方式不可為空");
        }
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
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

    public void setPhoto(File photo) {
        if (photo != null) {
            this.photoPath = photo.getAbsolutePath(); // 自動轉為絕對路徑字串
        }
}
