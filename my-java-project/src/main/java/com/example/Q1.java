package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Q1 {

    public static void main(String[] args) {
        // 1. 請將 "your_file.csv" 替換成您 CSV 檔案的實際路徑
        String csvFilePath = "C:\\Users\\linvaio\\Desktop\\students.csv";

        // 2. 請設定要計算平均值的欄位索引 (0 代表第一欄, 1 代表第二欄, 以此類推)
        int columnToAverage = 2;

        double total = 0;
        int count = 0;
        String line = "";
        String csvSplitBy = ",";
        boolean isFirstLine = true; // 用來跳過標頭

        // 使用 try-with-resources 確保 BufferedReader 會被自動關閉
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            while ((line = br.readLine()) != null) {
                // 3. 如果第一行是標頭，就跳過
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // 使用逗號作為分隔符來分割每一行
                String[] data = line.split(csvSplitBy);

                // 檢查該行是否有足夠的欄位
                if (data.length > columnToAverage) {
                    try {
                        // 將指定欄位的字串轉換為數字，並加到總和中
                        double value = Double.parseDouble(data[columnToAverage]);
                        total += value;
                        count++;
                    } catch (NumberFormatException e) {
                        // 如果某個值無法轉換為數字，則在主控台印出警告
                        System.err.println("警告: 無法解析的值 '" + data[columnToAverage] + "' 在行: " + line);
                    }
                }
            }

            // 4. 計算並印出平均值
            if (count > 0) {
                double average = total / count;
                System.out.println("總共讀取了 " + count + " 筆有效的數值。");
                System.out.println("總和為: " + total);
                System.out.println("平均值為: " + average);
            } else {
                System.out.println("在檔案中沒有找到有效的數值來計算平均值。");
            }

        } catch (FileNotFoundException e) {
            System.err.println("錯誤: 找不到檔案 " + csvFilePath);
        } catch (IOException e) {
            System.err.println("錯誤: 讀取檔案時發生錯誤 " + e.getMessage());
        }
    }
}
