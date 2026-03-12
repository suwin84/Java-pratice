import java.io.File;
import java.util.List;

public class IncomeCommand {
    private int money;
    private User user;
    private List<String> sourceOfIncome;
    private String remark;
    private File photo;

    public IncomeCommand(int money, User user, List<String> sourceOfIncome, String remark, File photo) {
        this.money = money;
        this.user = user;
        this.sourceOfIncome = sourceOfIncome;
        this.remark = remark;
        this.photo = photo;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
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

    public void setPhoto(File photo) {
        this.photo = photo;
    }
}
