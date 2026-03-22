package com.example.repository;

import com.example.config.DatabaseConfig;
import com.example.model.ExpenditureRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureRecordRepository {

    /**
     * 將一筆新的支出紀錄儲存到資料庫
     * 
     * @param record 要儲存的 ExpenditureRecord 物件
     */
    public void save(ExpenditureRecord record) {
        String sql = "INSERT INTO expenditure_records (amount, category_name, payment_method, record_date, remark, photo_path) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, record.getMoney()); // 假設 getMoney() 回傳 double 或 int

            // 假設 record.getCategory() 回傳 List<String>，我們取第一個
            if (record.getCategory() != null && !record.getCategory().isEmpty()) {
                pstmt.setString(2, record.getCategory().get(0));
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }

            // 假設 record.getPaymentMethod() 回傳 List<String>，我們取第一個
            if (record.getPaymentMethod() != null && !record.getPaymentMethod().isEmpty()) {
                pstmt.setString(3, record.getPaymentMethod().get(0));
            } else {
                pstmt.setNull(3, Types.VARCHAR);
            }

            // 將 java.time.LocalDate 轉換為 java.sql.Date
            if (record.getDate() != null) {
                pstmt.setDate(4, java.sql.Date.valueOf(record.getDate()));
            } else {
                pstmt.setNull(4, Types.DATE);
            }

            pstmt.setString(5, record.getRemark());
            pstmt.setString(6, record.getPhotoPath());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("儲存支出紀錄時發生錯誤: " + e.getMessage());
        }
    }

    /**
     * 從資料庫查詢所有的支出紀錄
     * 
     * @return 包含所有支出紀錄的列表
     */
    public List<ExpenditureRecord> findAll() {
        List<ExpenditureRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM expenditure_records";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ExpenditureRecord record = new ExpenditureRecord();
                record.setMoney(rs.getInt("amount")); // 從資料庫讀取金額

                // 將單一的 category_name 包裝成 List<String>
                List<String> categoryList = new ArrayList<>();
                categoryList.add(rs.getString("category_name"));
                record.setCategory(categoryList);

                // 將單一的 payment_method 包裝成 List<String>
                List<String> paymentMethodList = new ArrayList<>();
                paymentMethodList.add(rs.getString("payment_method"));
                record.setPaymentMethod(paymentMethodList);

                // 將 java.sql.Date 轉換為 java.time.LocalDate
                Date dbDate = rs.getDate("record_date");
                if (dbDate != null) {
                    record.setDate(dbDate.toLocalDate());
                }

                record.setRemark(rs.getString("remark"));
                record.setPhotoPath(rs.getString("photo_path"));

                records.add(record);
            }
        } catch (SQLException e) {
            System.err.println("查詢所有支出紀錄時發生錯誤: " + e.getMessage());
        }
        return records;
    }
}