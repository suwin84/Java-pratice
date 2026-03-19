package Command;

import Model.User;
import java.io.File;
import java.util.List;

public class IncomeCommand {
    private int money;
    private User user;
    private List<String> sourceOfIncome;
    private String remark;
    private String photoPath;
    private File photo;

    public IncomeCommand(int money, User user, List<String> sourceOfIncome, String remark, String photoPath) {
        this.money = money;
        this.user = user;
        this.sourceOfIncome = sourceOfIncome;
        this.remark = remark;
        this.photoPath = photoPath;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("金額不可為負數");
        }
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(List<String> sourceOfIncome) {
        if (sourceOfIncome == null || sourceOfIncome.isEmpty()) {
            throw new IllegalArgumentException("收入來源不可為空");
        }
        this.sourceOfIncome = sourceOfIncome;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public File getPhoto() {
        return photo;
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