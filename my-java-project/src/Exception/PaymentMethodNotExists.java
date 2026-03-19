package Exception;

import Model.PaymentMethod;
import Model.User;
import Model.StatisticsPoint;
import java.util.List;

public class PaymentMethodNotExists extends Exception {
    public PaymentMethodNotExists(String message) {
        super(message);
    }

    public PaymentMethodNotExists(String message, Throwable cause) {
        super(message, cause);
    }
}
