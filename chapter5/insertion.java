public class insertion {
    public static void main(String[] args) {
        insertion_func(Integer.parseInt("10011", 2), Integer.parseInt("10000000000", 2), 6, 2   );
    }
    public static void insertion_func(int m, int n, int j, int i) {
        int mask = (-1 << j) + (-1 >>> 32-i+1);
        String maskString = Integer.toBinaryString(mask).substring(32-Integer.toBinaryString(n).length());
        mask = Integer.parseInt(maskString, 2);
        System.out.println("Mask: " + Integer.toBinaryString(mask));
        System.out.println("N: " + Integer.toBinaryString(n));
        n = n & (mask);
        System.out.println("N after masking: " + Integer.toBinaryString(n));
        System.out.println("M: " + Integer.toBinaryString(m));
        m = Integer.parseInt(Integer.toBinaryString(m) + multiply("0", i), 2);
        System.out.println("M: " + Integer.toBinaryString(m));
        n = n | m;
        System.out.println("N after or'ing:  " + Integer.toBinaryString(n));
    }
    public static String multiply(String s, int x) {
        String res = "";
        while (x > 0) {
            res += s;
            --x;
        }
        return res;
    }
}