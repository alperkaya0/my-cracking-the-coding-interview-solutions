import java.util.ArrayList;

public class build_order {
    public static void main(String[] args) {
        ArrayList<String> p = new ArrayList<>();
        ArrayList<String[]> d = new ArrayList<>();
        p.add("a");
        p.add("b");
        p.add("c");
        p.add("d");
        p.add("e");
        p.add("f");
        
        d.add(new String[]{"a", "d"});
        d.add(new String[]{"f", "b"});
        d.add(new String[]{"b", "d"});
        d.add(new String[]{"f", "a"});
        d.add(new String[]{"d", "c"});

        for (String[] dp : d) {
            if (p.indexOf(dp[0]) > p.indexOf(dp[1])) {
                String temp = dp[0];
                p.remove(p.indexOf(dp[0]));
                p.add(p.indexOf(dp[1]), temp);
            }
        }

        System.out.println(p);
    }
}
