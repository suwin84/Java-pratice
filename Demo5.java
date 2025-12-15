package HELLOWORLD;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = scanner.nextInt();
        int[] ans = new int[5];
        int val =((max / 5 )+1)*5;
        ans[0]=( val / 5 ) * 4;
        ans[1]=( val / 5 ) * 3;
        ans[2]=( val / 5 ) * 2;
        ans[3]=( val / 5 ) * 1;
        ans[4]=( val / 5 ) * 0;
        }
}
