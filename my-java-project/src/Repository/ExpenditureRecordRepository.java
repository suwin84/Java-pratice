package Repository;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import com.example.model.ExpenditureRecord;
import com.example.model.User;

public class ExpenditureRecordRepository {
    private List<ExpenditureRecord> expenditureRecords = new ArrayList<>();

    public List<ExpenditureRecord> findByDate(LocalDate date) {
        List<ExpenditureRecord> result = new ArrayList<>();
        for (ExpenditureRecord record : expenditureRecords) {
            if (record.getDate().equals(date)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<ExpenditureRecord> findByPaymentMethod(String paymentMethod) {
        List<ExpenditureRecord> result = new ArrayList<>();
        for (ExpenditureRecord record : expenditureRecords) {
            if (record.getPaymentMethod().equals(paymentMethod)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<ExpenditureRecord> findByCategory(String category) {
        List<ExpenditureRecord> result = new ArrayList<>();
        for (ExpenditureRecord record : expenditureRecords) {
            if (record.getCategory().equals(category)) {
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
