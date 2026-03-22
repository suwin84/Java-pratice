package com.example.config;

public class DatabaseConfig {

    /**
     * 資料庫連線 URL
     * jdbc:mysql:// 是協定
     * localhost:3306 是您的資料庫主機和連接埠
     * 請務必將 "your_database_name" 替換成您實際的資料庫名稱
     */
    public static final String DB_URL = "jdbc:mysql://localhost:3306/accounting_app_db?useSSL=false&serverTimezone=UTC";

    /**
     * 資料庫使用者名稱
     * 請替換成您的 MySQL 使用者名稱 (例如 "root")
     */
    public static final String DB_USER = "root";

    /**
     * 資料庫密碼
     * 請替換成您的 MySQL 密碼
     * 再次提醒：在正式專案中，切勿將密碼寫死在程式碼裡！
     */
    public static final String DB_PASSWORD = "123456";

}
