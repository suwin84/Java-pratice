package Command;

import Model.User;

public class CategoryCreateCommand {
    private User user;
    private String name;
    private String icon;

    public CategoryCreateCommand(User user, String name, String icon) {
        setUser(user);
        setName(name);
        setIcon(icon);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("請輸入消費類別名稱");
        }
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        if (icon == null || icon.trim().isEmpty()) {
            throw new IllegalArgumentException("請輸入圖示");
        }
        this.icon = icon;
    }
}