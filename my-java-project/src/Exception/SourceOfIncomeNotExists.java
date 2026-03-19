package Exception;

import com.example.model.SourceOfIncome;
import Model.User;
import Model.StatisticsPoint;
import java.util.List;

public class SourceOfIncomeNotExists extends Exception {
    public SourceOfIncomeNotExists(String message) {
        super(message);
    }

    public SourceOfIncomeNotExists(String message, Throwable cause) {
        super(message, cause);
    }
}
