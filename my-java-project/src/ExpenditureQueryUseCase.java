import java.util.ArrayList;
import java.util.List;

public class ExpenditureQueryUseCase {
    private ExpenditureRecordRepository expenditureRecordRepository;

    public ExpenditureQueryUseCase(ExpenditureRecordRepository expenditureRecordRepository) {
        this.expenditureRecordRepository = expenditureRecordRepository;
    }

    public List<ExpenditureRecord> query(ExpenditureQueryCommand command) {
        List<ExpenditureRecord> results = new ArrayList<>();

        if (command == null) {
            return expenditureRecordRepository.findAll();
        }

        // 根據查詢條件進行篩選
        List<ExpenditureRecord> allRecords = expenditureRecordRepository.findAll();

        for (ExpenditureRecord record : allRecords) {
            boolean matches = true;

            // 按日期篩選
            if (command.getDate() != null && !record.getDate().equals(command.getDate())) {
                matches = false;
            }

            // 按付款方式篩選
            if (matches && command.getPaymentMethod() != null) {
                boolean paymentMethodMatch = false;
                if (record.getPaymentMethod() != null) {
                    for (String method : record.getPaymentMethod()) {
                        if (method.equals(command.getPaymentMethod())) {
                            paymentMethodMatch = true;
                            break;
                        }
                    }
                }
                if (!paymentMethodMatch) {
                    matches = false;
                }
            }

            // 按分類篩選
            if (matches && command.getCategory() != null) {
                boolean categoryMatch = false;
                if (record.getCategory() != null) {
                    for (String cat : record.getCategory()) {
                        if (cat.equals(command.getCategory())) {
                            categoryMatch = true;
                            break;
                        }
                    }
                }
                if (!categoryMatch) {
                    matches = false;
                }
            }

            if (matches) {
                results.add(record);
            }
        }

        return results;
    }
}
