package com.example.repository;

import com.example.Category;
import com.example.config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    /**
     * 從資料庫查詢所有的消費類別
     * 
     * @return 包含所有類別的列表
     */
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        // 使用 try-with-resources 自動關閉連線資源
        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            // 遍歷查詢結果
            while (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString("name"));
                category.setType(rs.getString("type"));
                category.setIcon(rs.getString("icon"));
                categories.add(category);
            }
        } catch (SQLException e) {
            System.err.println("查詢所有類別時發生錯誤: " + e.getMessage());
        }
        return categories;
    }

    /**
     * 將一個新的消費類別儲存到資料庫
     * 
     * @param c 要儲存的 Category 物件
     */
    public void save(Category c) {
        // 首先檢查名稱是否已存在，避免重複
        if (existsByName(c.getName())) {
            System.out.println("該消費類別已存在");
            return;
        }

        String sql = "INSERT INTO categories(name, type, icon) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 設定 SQL 指令中的參數，防止 SQL 注入
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getType());
            pstmt.setString(3, c.getIcon());

            // 執行更新
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("儲存類別時發生錯誤: " + e.getMessage());
        }
    }

    /**
     * 檢查指定的類別名稱是否已存在於資料庫中
     * 
     * @param name 要檢查的名稱
     * @return 如果存在則回傳 true，否則回傳 false
     */
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM categories WHERE name = ?";
        boolean exists = false;

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 如果查詢到的數量大於 0，代表已存在
                    exists = rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("檢查類別名稱是否存在時發生錯誤: " + e.getMessage());
        }
        return exists;
    }
}