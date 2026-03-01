package com.example.infrastructure.persistence;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.sql.Connection;
import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.model.User;
import com.example.infrastructure.util.DatabaseConnectionFactory;

/**
 * MySQL 使用者儲存庫整合測試
 * 
 * 此測試驗證：
 * 1. 資料庫連線有效性
 * 2. 登入驗證成功情境（正確密碼、大小寫不敏感）
 * 3. 登入驗證失敗情境（錯誤密碼、不存在使用者）
 * 
 * 前置條件：
 * 1. Docker MySQL 容器必須運行 (northwind_mysql)
 * 2. 資料庫中應存在測試帳號：admin, user, test
 */
public class MySQLUserRepositoryTest {

    private static boolean isDatabaseAvailable = false;
    private MySQLUserRepository repository;

    @BeforeClass
    public static void checkDatabaseAvailability() {
        try (Connection conn = DatabaseConnectionFactory.getConnection()) {
            isDatabaseAvailable = true;
            System.out.println("✓ 資料庫連線成功");
        } catch (Exception e) {
            isDatabaseAvailable = false;
            System.err.println("⚠ 資料庫連線失敗: " + e.getMessage());
        }
    }

    @Before
    public void setUp() {
        assumeTrue("資料庫未啟動，跳過測試", isDatabaseAvailable);
        repository = new MySQLUserRepository();
    }

    // ==================== 資料庫連線驗證 ====================

    /**
     * 驗證資料庫連線有效性
     */
    @Test
    public void testDatabaseConnectionValidity() {
        try (Connection conn = DatabaseConnectionFactory.getConnection()) {
            assertNotNull("資料庫連線應該成功", conn);
            System.out.println("✓ 資料庫連線有效");
        } catch (Exception e) {
            fail("資料庫連線失敗: " + e.getMessage());
        }
    }

    // ==================== 登入驗證測試 ====================

    /**
     * 測試登入成功情境
     * 驗證：正確密碼、大小寫不敏感、使用者存在
     */
    @Test
    public void testLoginSuccess() {
        // 情境1：正確密碼登入
        Optional<User> user = repository.findByUsername("admin");
        assertTrue("使用者 admin 應該存在", user.isPresent());
        boolean success = user.map(u -> u.getPassword().equalsIgnoreCase("admin")).orElse(false);
        assertTrue("正確密碼應該驗證成功", success);

        // 情境2：密碼大小寫不敏感
        user = repository.findByUsername("admin");
        success = user.map(u -> u.getPassword().equalsIgnoreCase("ADMIN")).orElse(false);
        assertTrue("密碼大小寫不敏感驗證應該成功", success);

        // 情境3：驗證其他測試帳號
        user = repository.findByUsername("user");
        assertTrue("使用者 user 應該存在", user.isPresent());

        System.out.println("✓ 登入成功驗證通過");
    }

    /**
     * 測試登入失敗情境
     * 驗證：錯誤密碼、不存在使用者、null/空值等
     */
    @Test
    public void testLoginFailure() {
        // 情境1：錯誤密碼
        Optional<User> user = repository.findByUsername("admin");
        boolean failed = user.map(u -> u.getPassword().equalsIgnoreCase("wrongpass")).orElse(false);
        assertFalse("錯誤密碼應該驗證失敗", failed);

        // 情境2：不存在的使用者
        user = repository.findByUsername("nonexistent_user");
        assertFalse("不存在的使用者應該無法找到", user.isPresent());

        // 情境3：null/空值查詢
        user = repository.findByUsername(null);
        assertFalse("null 使用者名稱應該無法找到", user.isPresent());

        user = repository.findByUsername("");
        assertFalse("空字串使用者名稱應該無法找到", user.isPresent());

        System.out.println("✓ 登入失敗驗證通過");
    }
}
