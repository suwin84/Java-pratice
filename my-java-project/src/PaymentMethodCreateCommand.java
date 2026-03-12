public class PaymentMethodCreateCommand {
    private User user;
    private String name;
    private String type;

    public PaymentMethodCreateCommand(User user, String name, String type) {
        this.user = user;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
