public class Demo6 {
    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            System.out.println(i + ":" + rec_fun(i));
        }

    }

    public static int rec_fun(int n) {
        if (n <= 1)
            return n;
        else
            return rec_fun(n - 1) + rec_fun(n - 2);
    }
