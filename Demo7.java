public class Demo7 {
    public static void main(String[] args) {
        int min_len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min_len = Math.min(strs[i].length(), min_len);
        }

        boolean isMatch = true;
        int idx = 0;
        for (int i = 1; i < strs.length; i++) {
            if(!isMatch)
                break;

            for (int j = 0; j < min_len; j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    System.out.println(strs[0].charAt(i) + ", " + strs[i].charAt(j) + "不一樣!");
                    idx = j;
                    isMatch = false;
                    break;
                }
            }
        }

    }
}
