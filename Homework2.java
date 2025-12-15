import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    String num = scanner.next();

    for(int i=num.length()-1;i>=0;i--){
        System.out.print(num.charAt(i));
    }

    scanner.close();
    }
}
