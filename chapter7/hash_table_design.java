package chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class hash_table_design {
    public static void main(String[] args) {
        hash_table h = new hash_table();
        HashMap<String, Integer> hm = new HashMap<>();
        Random r = new Random();
        boolean passed = true;

        for (int j = 0; j < 100; ++j) {
            String key = "";
            for (int i = 0; i < r.nextInt(10)+1; ++i) {
                key += Character.toString((char)r.nextInt(57)+65);
            }
            int value = r.nextInt(100);
            h.insert(key, value);
            hm.put(key, value);
        }
        
        for (String key : hm.keySet()) {
            if (h.find(key) != hm.get(key)) {
                System.out.println(key + "=" + hm.get(key) + " ,expected... but found: " + key + "=" + h.find(key));
                passed = false;
            }
        }
        if (passed) {
            System.out.println("All passed c:");
        }
        System.out.println(h);
        System.out.println("Arr.length: " + h.arr.length);
    }
}
class hash_table_node {
    String label;
    int val;
    hash_table_node next;
    hash_table_node(int val) {
        this.val = val;
    }
    hash_table_node() {

    }
}
class hash_table  {
    hash_table_node[] arr = new hash_table_node[10];
    ArrayList<String> keySet = new ArrayList<>();
    int insertion = 0;
    int amortized_multiplier = 3;
    public int find(String key) {
        hash_table_node temp = arr[hash(key)];
        if (temp.next == null) {
            return temp.val;
        } else {
            while (!temp.label.equals(key)) {
                temp = temp.next;
            }
            return temp.val;
        }
    }
    
    public void insert(String key, int val) {//don't forget to increase size of arr whenever necessary, amortized time
        keySet.add(key);
        ++insertion;
        int hash = hash(key);
        if (arr[hash] == null) {
            hash_table_node temp = new hash_table_node(val);
            temp.label = key;
            arr[hash] = temp;
        } else {
            hash_table_node p = arr[hash];
            hash_table_node temp = new hash_table_node(val);
            temp.label = key;
            while (p.next != null) {
                if (p.label.equals(temp.label))
                    break;
                p = p.next;
            }
            if (p.label.equals(key))
                p.val = temp.val;
            else
                p.next = temp;
        }
        if (insertion == arr.length / this.amortized_multiplier) {
            hash_table_node[] newarr = new hash_table_node[arr.length * this.amortized_multiplier];
            for (String key_ : keySet) {
                newarr[hash(key_, newarr.length)] = arr[hash(key_)];
            }
            this.arr = newarr;
            insertion = 0;
        }
    }
    private int hash(String value) {
        int temp = 0;
        for (int i = 0; i < value.length(); ++i) {
            temp += (i + 1) * (int) value.charAt(i);
        }

        return temp % arr.length;
    }
    private int hash(String value, int length) {
        int temp = 0;
        for (int i = 0; i < value.length(); ++i) {
            temp += (i + 1) * (int) value.charAt(i);
        }

        return temp % length;
    }
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < arr.length; ++i) {
            hash_table_node p = arr[hash(keySet.get(i))];
            if (p != null){
                while (p != null) {
                    res += p.val + "-> ";
                    p = p.next;
                }
                res += "\n";
            }
        }
        return res;
    }
}