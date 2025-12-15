import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //input : 97, output : 100
        //input : 14, output : 15 , diff = 3 => 等份

        //int s = 62 / 5;

        int max = scanner.nextInt();

        int ans = ((max / 5 )+ 1) * 5;
        int ans1 = (ans / 5) * 4;
        int ans2 = (ans / 5) * 3;
        int ans3 = (ans / 5) * 2;
        int ans4 = (ans / 5) * 1;
        int ans5 = (ans / 5) * 0;

        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
        System.out.println(ans5);
    }
}
