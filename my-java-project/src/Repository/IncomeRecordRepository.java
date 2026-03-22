package com.example.repository;

import com.example.config.DatabaseConfig;
import com.example.model.IncomeRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeRecordRepository {

    /**
     * 將一筆新的收入紀錄儲存到資料庫
     * 
     * @param record 要儲存的 IncomeRecord 物件
     */
    public void save(IncomeRecord record) {
        String sql = "INSERT INTO income_records (amount, source_of_income, record_date, remark) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, record.getMoney());

            // 假設 record.getSourceOfIncome() 回傳 List<String>，我們取第一個
            if (record.getSourceOfIncome() != null && !record.getSourceOfIncome().isEmpty()) {
                pstmt.setString(2, record.getSourceOfIncome().get(0));
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }

            // 將 java.time.LocalDate 轉換為 java.sql.Date
            if (record.getDate() != null) {
                pstmt.setDate(3, java.sql.Date.valueOf(record.getDate()));
            } else {
                pstmt.setNull(3, Types.DATE);
            }

            pstmt.setString(4, record.getRemark());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("儲存收入紀錄時發生錯誤: " + e.getMessage());
        }
    }

    /**
     * 從資料庫查詢所有的收入紀錄
     * 
     * @return 包含所有收入紀錄的列表
     */
    public List<IncomeRecord> findAll() {
        List<IncomeRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM income_records";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                IncomeRecord record = new IncomeRecord();
                record.setMoney(rs.getInt("amount"));

                // 將單一的 source_of_income 包裝成 List<String>
                List<String> sourceList = new ArrayList<>();
                sourceList.add(rs.getString("source_of_income"));
                record.setSourceOfIncome(sourceList);

                // 將 java.sql.Date 轉換為 java.time.LocalDate
                Date dbDate = rs.getDate("record_date");
                if (dbDate != null) {
                    record.setDate(dbDate.toLocalDate());
                }

                record.setRemark(rs.getString("remark"));

                records.add(record);
            }
        } catch (SQLException e) {
            System.err.println("查詢所有收入紀錄時發生錯誤: " + e.getMessage());
        }
        return records;
    }
}