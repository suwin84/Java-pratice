package com.example.repository;

import com.example.config.DatabaseConfig;
import com.example.model.SourceOfIncome;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SourceOfIncomeRepository {

    /**
     * 從資料庫查詢所有的收入來源
     * 
     * @return 包含所有收入來源的列表
     */
    public List<SourceOfIncome> findAll() {
        List<SourceOfIncome> sources = new ArrayList<>();
        String sql = "SELECT * FROM source_of_incomes";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                SourceOfIncome source = new SourceOfIncome();
                source.setName(rs.getString("name"));
                sources.add(source);
            }
        } catch (SQLException e) {
            System.err.println("查詢所有收入來源時發生錯誤: " + e.getMessage());
        }
        return sources;
    }

    /**
     * 將一個新的收入來源儲存到資料庫
     * 
     * @param sourceOfIncome 要儲存的 SourceOfIncome 物件
     */
    public void save(SourceOfIncome sourceOfIncome) {
        String sql = "INSERT INTO source_of_incomes (name) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sourceOfIncome.getName());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // 檢查是否是唯一的鍵衝突錯誤 (error code 1062 for MySQL)
            if (e.getErrorCode() == 1062) {
                System.err.println("收入來源 '" + sourceOfIncome.getName() + "' 已存在。");
            } else {
                System.err.println("儲存收入來源時發生錯誤: " + e.getMessage());
            }
        }
    }

    /**
     * 檢查指定的收入來源名稱是否已存在於資料庫
     * 
     * @param name 要檢查的名稱
     * @return 如果存在則返回 true，否則返回 false
     */
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM source_of_incomes WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("檢查收入來源是否存在時發生錯誤: " + e.getMessage());
        }
        return false;
    }
}