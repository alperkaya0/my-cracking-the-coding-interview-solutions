public class conversion {
    public static void main(String[] args) {
        System.out.println(conversion_func("11101", "01111"));
    }
    public static int conversion_func(int first, int second) {
        String s = Integer.toBinaryString(first ^ second);
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.substring(i, i + 1).equals("1"))
                ++res;
        }
        return res;
    }
    public static int conversion_func(String first, String second) {
        String s = Integer.toBinaryString(Integer.parseInt(first, 2) ^ Integer.parseInt(second, 2));
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.substring(i, i + 1).equals("1"))
                ++res;
        }
        return res;
    }
}
