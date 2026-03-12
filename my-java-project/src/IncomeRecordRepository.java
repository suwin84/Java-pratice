package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IncomeRecordRepository {
    private List<IncomeRecord> incomeRecords = new ArrayList<>();

    public List<IncomeRecord> findAll() {
        return new ArrayList<>(incomeRecords);
    }

    public List<IncomeRecord> findByDate(LocalDate date) {
        return incomeRecords.stream()
                .filter(record -> record.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<IncomeRecord> findBySourceOfIncome(String sourceOfIncome) {
        return incomeRecords.stream()
                .filter(record -> record.getSourceOfIncome().getName().equals(sourceOfIncome))
                .collect(Collectors.toList());
    }

    public void save(IncomeRecord incomeRecord) {
        if (incomeRecord != null) {
            incomeRecords.add(incomeRecord);
        }
    }
}
