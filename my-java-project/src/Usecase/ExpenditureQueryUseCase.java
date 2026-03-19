package Usecase;

import Command.ExpenditureQueryCommand;
import Model.ExpenditureRecord;
import Model.User;
import Repository.ExpenditureRecordRepository;
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
                // 直接使用 .contains() 檢查列表是否包含該付款方式
                if (!record.getPaymentMethod().contains(command.getPaymentMethod())) {
                    matches = false; // 如果不包含，就淘汰
                }
            }

            // 按分類篩選
            if (matches && command.getCategory() != null && !record.getCategory().contains(command.getCategory())) {
                matches = false;
            }

            if (matches) {
                results.add(record);
            }
        }

        return results;
    }
}