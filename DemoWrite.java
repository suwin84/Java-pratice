public class DemoWrite {
public static void main(String[] args) {
    String[] testTests = {
        "Hello World - This is English test",
        "你好，世界！這是中文測試。",
        "English is OK, but Chinese: 台灣繁體中文測試",
        "Mix: ABC 123 測試 XYZ 編碼問題",
    };

    try (FileWriter fileWriter = new FileWriter(filename)){
        
        for (int i = 0; i < testTests.length; i++){
            fileWriter.write(testTests[i] + "\n");
        }

    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
}    
}