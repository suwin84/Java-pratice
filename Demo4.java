import java.util.Scanner;

public class  {
    // 整除 的情況
    // 沒整除 的情況

    // 67 -> (12 + 1) * 5
    // 60 -> 12
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int max = scanner.nextInt();
        int val = max % 5;
        if(val == 0){
            System.out.println((max / 5)*5);
        }else{
            System.out.println(((max / 5)+1)*5);
        }
    }
}
