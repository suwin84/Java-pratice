public class SourceOfIncomeCreateCommand {
    private User user;
    private String name;
    private String icon;

    public SourceOfIncomeCreateCommand(User user, String name, String icon) {
        this.user = user;
        this.name = name;
        this.icon = icon;
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
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
