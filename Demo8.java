import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(finTarget(new int[]{75,50,29,92,123,12,5}, 5));
        System.out.println(finTarget(new int[]{75,50,29,92,123,12,5}, 50));
        System.out.println(finTarget(new int[]{75,50,29,92,123,12,5}, 11));
        System.out.println(finTarget(new int[]{}, 11));

        scanner.close();
    }

    public static int finTarget(int[] values, int target) {
        if (values.length == 0)
            return -1;

        for (int i = 0; i < values.length; i++) {
            if ( values[i] == target){
                return  i;
            }
        }

        return -2;
    }

}
