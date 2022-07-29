public class pairwise_swap {
    public static void main(String[] args) {
        pairwise_swap_func("101010");//010101 expected
    }
    public static void pairwise_swap_func(String s) {
        int len = s.length();
        String odd = "";
        String even = "";
        for (int i = 0; i < len; ++i) {
            if (i % 2 == 0) {
                even += "1";
                odd += "0";
            } else {
                even += "0";
                odd += "1";
            }
        }
        int oddi = Integer.parseInt(odd, 2) & Integer.parseInt(s, 2);
        int eveni = Integer.parseInt(even, 2) & Integer.parseInt(s, 2);
        oddi = oddi << 1;
        eveni = eveni >> 1;
        
        System.out.println(oddi|eveni);
        System.out.println(Integer.toBinaryString(oddi|eveni));
    }
}