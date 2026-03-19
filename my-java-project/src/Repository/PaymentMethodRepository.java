package Repository;

import Model.PaymentMethod;
import java.util.ArrayList;
import java.util.List;
import Model.User;

public class PaymentMethodRepository {
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public List<PaymentMethod> findAll() {
        return new ArrayList<>(paymentMethods);
    }

    public List<PaymentMethod> findByName(String name) {
        List<PaymentMethod> result = new ArrayList<>();
        for (PaymentMethod pm : paymentMethods) {
            if (pm.getName().equals(name)) {
                result.add(pm);
            }
        }
        return result;
    }

    public boolean existsByName(String name) {
        for (PaymentMethod pm : paymentMethods) {
            if (pm.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void save(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
    }
}
