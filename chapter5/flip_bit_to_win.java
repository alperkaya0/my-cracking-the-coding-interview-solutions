import java.util.Arrays;

public class flip_bit_to_win {
    public static void main(String[] args) {
        flip_bit_to_win_func("11011101111");
    }
    public static void flip_bit_to_win_func(String bits) {//Assumption: There is only one 0 resides between any 1 sequence
        String[] arr = bits.split("0");
        int[] int_arr = new int[arr.length];
        int i = 0;
        for (String s : arr) {
            int_arr[i++] = s.length();
        }
        Arrays.sort(int_arr);
        System.out.println("The max: " + (int_arr[int_arr.length - 1] + int_arr[int_arr.length - 2] + 1));//One more because of the 0 that we flipped to 1
    }
}
