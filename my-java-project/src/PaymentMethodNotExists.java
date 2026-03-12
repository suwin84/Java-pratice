public class PaymentMethodNotExists extends Exception {
    public PaymentMethodNotExists(String message) {
        super(message);
    }

    public PaymentMethodNotExists(String message, Throwable cause) {
        super(message, cause);
    }
}
