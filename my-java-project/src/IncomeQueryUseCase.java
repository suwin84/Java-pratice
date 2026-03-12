package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class IncomeQueryUseCase {
    private IncomeRecordRepository incomeRecordRepository;

    public IncomeQueryUseCase(IncomeRecordRepository incomeRecordRepository) {
        this.incomeRecordRepository = incomeRecordRepository;
    }

    public List<IncomeRecord> query(IncomeQueryCommand command) {
        List<IncomeRecord> records = incomeRecordRepository.findAll();

        if (command.getDate() != null) {
            records = records.stream()
                    .filter(record -> record.getDate().equals(command.getDate()))
                    .collect(Collectors.toList());
        }

        if (command.getSourceOfIncome() != null) {
            records = records.stream()
                    .filter(record -> record.getSourceOfIncome().equals(command.getSourceOfIncome()))
                    .collect(Collectors.toList());
        }

        if (command.getUser() != null) {
            records = records.stream()
                    .filter(record -> record.getUser().equals(command.getUser()))
                    .collect(Collectors.toList());
        }

        return records;
    }
}
