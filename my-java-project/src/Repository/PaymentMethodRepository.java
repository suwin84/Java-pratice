package com.example.repository;

import com.example.config.DatabaseConfig;
import com.example.model.PaymentMethod;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRepository {

    /**
     * 從資料庫查詢所有的支付方式
     * 
     * @return 包含所有支付方式的列表
     */
    public List<PaymentMethod> findAll() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        String sql = "SELECT * FROM payment_methods";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PaymentMethod pm = new PaymentMethod();
                pm.setName(rs.getString("name"));
                paymentMethods.add(pm);
            }
        } catch (SQLException e) {
            System.err.println("查詢所有支付方式時發生錯誤: " + e.getMessage());
        }
        return paymentMethods;
    }

    /**
     * 將一個新的支付方式儲存到資料庫
     * 
     * @param paymentMethod 要儲存的 PaymentMethod 物件
     */
    public void save(PaymentMethod paymentMethod) {
        String sql = "INSERT INTO payment_methods (name) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, paymentMethod.getName());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // 檢查是否是唯一的鍵衝突錯誤 (error code 1062 for MySQL)
            if (e.getErrorCode() == 1062) {
                System.err.println("支付方式 '" + paymentMethod.getName() + "' 已存在。");
            } else {
                System.err.println("儲存支付方式時發生錯誤: " + e.getMessage());
            }
        }
    }

    /**
     * 檢查指定的支付方式名稱是否已存在於資料庫
     * 
     * @param name 要檢查的名稱
     * @return 如果存在則返回 true，否則返回 false
     */
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM payment_methods WHERE name = ?";

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
            System.err.println("檢查支付方式是否存在時發生錯誤: " + e.getMessage());
        }
        return false;
    }
}