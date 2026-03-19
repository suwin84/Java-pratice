package Usecase;

import Command.IncomeStatisticsCommand;
import Model.IncomeRecord;
import Repository.IncomeRecordRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class IncomeStatisticsUseCase {
    private IncomeRecordRepository incomeRecordRepository;

    public IncomeStatisticsUseCase(IncomeRecordRepository incomeRecordRepository) {
        this.incomeRecordRepository = incomeRecordRepository;
    }

    public void calculate(IncomeStatisticsCommand command) {
        List<IncomeRecord> records = incomeRecordRepository.findAll();

        if (command.getDate() != null) {
            LocalDate date = command.getDate();
            records = records.stream()
                    .filter(record -> record.getDate().equals(date))
                    .collect(Collectors.toList());
        }

        if (command.getSourceOfIncome() != null && !command.getSourceOfIncome().isEmpty()) {
            List<String> sourceOfIncomeList = command.getSourceOfIncome();
            records = records.stream()
                    .filter(record -> sourceOfIncomeList.contains(record.getSourceOfIncome()))
                    .collect(Collectors.toList());
        }

        // 計算統計數據
        if (!records.isEmpty()) {
            double totalAmount = records.stream()
                    .mapToDouble(IncomeRecord::getMoney)
                    .sum();
            double averageAmount = records.stream()
                    .mapToDouble(IncomeRecord::getMoney)
                    .average()
                    .orElse(0);
            int recordCount = records.size();

            // 輸出統計結果
            System.out.println("總收入: " + totalAmount);
            System.out.println("平均收入: " + averageAmount);
            System.out.println("記錄數: " + recordCount);
        }
    }
}
