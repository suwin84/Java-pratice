import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenditureRecordRepository {
    private List<ExpenditureRecord> expenditureRecords = new ArrayList<>();

    public List<ExpenditureRecord> findByDate(Date date) {
        List<ExpenditureRecord> result = new ArrayList<>();
        for (ExpenditureRecord record : expenditureRecords) {
            if (record.getDate() != null && record.getDate().equals(date)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<ExpenditureRecord> findByPaymentMethod(String paymentMethod) {
        List<ExpenditureRecord> result = new ArrayList<>();
        for (ExpenditureRecord record : expenditureRecords) {
            if (record.getPaymentMethod() != null && record.getPaymentMethod().equals(paymentMethod)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<ExpenditureRecord> findByCategory(String category) {
        List<ExpenditureRecord> result = new ArrayList<>();
        for (ExpenditureRecord record : expenditureRecords) {
            if (record.getCategory() != null && record.getCategory().equals(category)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<ExpenditureRecord> findAll() {
        return new ArrayList<>(expenditureRecords);
    }

    public void save(ExpenditureRecord record) {
        if (record != null) {
            expenditureRecords.add(record);
        }
    }
}
