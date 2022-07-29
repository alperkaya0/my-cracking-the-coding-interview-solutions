public class binary_to_string {
    public static void main(String[] args) {
        string_to_double(binary_to_string_func("0.333"));
    }
    public static String binary_to_string_func(String val) {
        String res = "";
        double v = Double.valueOf(val);
        double p = 0.5;
        while(v > 0) {
            if (v-p >= 0) {
                res += "1";
                v -= p;
            }else {
                res += "0";
            }
            p /= 2;
        }
        res = "." + res;
        System.out.println(res);
        if (res.length() > 33) {
            System.out.println("ERROR. It is impossible to represent it with 32 bits. Current length: " + (res.length() - 1));
        }
        return res;
    }
    public static void string_to_double(String s) {
        if (s.contains(".")) {
            s = s.split("[.]")[1];
        }
        double res = 0;
        double p = 0.5;
        for (int i = 0; i < s.length(); ++i) {
            if (s.substring(i, i + 1).equals("1")) {
                res += p;
            }

            p /= 2;
        }
        System.out.println("Error check: " + res);
    }
}
