﻿package Usecase;

import Repository.ExpenditureRecordRepository;
import Command.ExpenditureStatisticsCommand;
import Model.ExpenditureRecord;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
                if (!record.getDate().equals(command.getDate())) {
                    matches = false;
                }
            }

            // 按分類篩選
            if (matches && command.getCategory() != null && !command.getCategory().isEmpty()) {
                if (record.getCategory() == null || Collections.disjoint(record.getCategory(), command.getCategory())) {
                    matches = false;
                }
            }

            // 按付款方式篩選
            if (matches && command.getPaymentMethod() != null && !command.getPaymentMethod().isEmpty()) {
                if (record.getPaymentMethod() == null
                        || Collections.disjoint(record.getPaymentMethod(), command.getPaymentMethod())) {
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