import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureStatisticsUseCase {
    private ExpenditureRecordRepository expenditureRecordRepository;

    public ExpenditureStatisticsUseCase(ExpenditureRecordRepository expenditureRecordRepository) {
        this.expenditureRecordRepository = expenditureRecordRepository;
    }

    public void calculate(ExpenditureStatisticsCommand command) {
        if (command == null) {
            return;
        }

        List<ExpenditureRecord> allRecords = expenditureRecordRepository.findAll();
        List<ExpenditureRecord> filteredRecords = new ArrayList<>();

        for (ExpenditureRecord record : allRecords) {
            boolean matches = true;

            // 按日期篩選
            if (command.getDate() != null && record.getDate() != null) {
                // 比較日期（簡化版本，實際需轉換 Date 為 LocalDate）
                if (!record.getDate().toString().contains(command.getDate().toString())) {
                    matches = false;
                }
            }

            // 按分類篩選
            if (matches && command.getCategory() != null && !command.getCategory().isEmpty()) {
                boolean categoryMatch = false;
                if (record.getCategory() != null) {
                    for (String cat : record.getCategory()) {
                        if (command.getCategory().contains(cat)) {
                            categoryMatch = true;
                            break;
                        }
                    }
                }
                if (!categoryMatch) {
                    matches = false;
                }
            }

            // 按付款方式篩選
            if (matches && command.getPaymentMethod() != null && !command.getPaymentMethod().isEmpty()) {
                boolean paymentMatch = false;
                if (record.getPaymentMethod() != null) {
                    for (String method : record.getPaymentMethod()) {
                        if (command.getPaymentMethod().contains(method)) {
                            paymentMatch = true;
                            break;
                        }
                    }
                }
                if (!paymentMatch) {
                    matches = false;
                }
            }

            if (matches) {
                filteredRecords.add(record);
            }
        }

        // 計算統計數據
        calculateStatistics(filteredRecords);
    }

    private void calculateStatistics(List<ExpenditureRecord> records) {
        if (records.isEmpty()) {
            System.out.println("沒有符合條件的支出記錄");
            return;
        }

        int totalAmount = 0;
        for (ExpenditureRecord record : records) {
            totalAmount += record.getMoney();
        }

        System.out.println("統計結果:");
        System.out.println("  記錄數量: " + records.size());
        System.out.println("  總支出: " + totalAmount);
        System.out.println("  平均支出: " + (totalAmount / records.size()));
    }
}
