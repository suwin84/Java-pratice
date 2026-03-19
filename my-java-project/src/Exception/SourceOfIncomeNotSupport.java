package Exception;

public class SourceOfIncomeNotSupport extends Exception {
    public SourceOfIncomeNotSupport(String message) {
        super(message);
    }

    public SourceOfIncomeNotSupport(String message, Throwable cause) {
        super(message, cause);
    }
}
