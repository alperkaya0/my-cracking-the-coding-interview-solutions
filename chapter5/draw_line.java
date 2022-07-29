public class draw_line {
    public static void main(String[] args) {
        byte[] screen = new byte[64];
        for (int i = 0; i < screen.length; ++i) {
            screen[i] = 0;
        }

        drawline(screen, 8, 10, 16, 8);//x1, x2 and y are all 1 indexed
    }
    public static void drawline(byte[] screen, int width, int x1, int x2, int y) {
        --y;
        if(y < 0) {
            y = 0;
        }
        byte[][] s = new byte[screen.length/width][width];//I am going to create a 2d screen out of our 1d screen just to work more comfortable
        int i = 0;
        int j = 0;
        for (byte b : screen) {
            if (i == (width)) {
                i = 0;
                ++j;
            }
            s[j][i] = b;
            ++i;
        }
        int target1 = (x1 == 0 ? 1 : x1 - 1) / 8;//which byte to change? index for our 2d array
        int index1 = ((x1 == 0 ? 1 : x1) - 1) % 8;//which bits to change? 0-7

        int target2 = (x2 == 0 ? 1 : x2 - 1) / 8;//same thing for x2
        int index2 = ((x2 == 0 ? 1 : x2) - 1) % 8;//same thing for x2

        int intertargets = target2 - target1 - 1;//if targets are obviously far away, then fill between of them

        if (intertargets > 0) {
            while (intertargets > 0) {
                s[y][intertargets+target1] = -1;//we are setting it -1 because binary representation of -1 is 11111111
                --intertargets;
            }
        }
        if (target1 == target2) {//if they are on the same byte, then we need to do something else
            int res1 = (byte) ~(-1 << (8 - index1));//index1 times 0 + (8-index1) times 1, for example if index1 = 3, res1 = 00011111
            ++index2;//to make the right border inclusive
            int res2 = (byte)  (-1 << (8 - index2));//index2 times 1 + (8-index2) times 0, for example if index2 = 3, res2 = 11100000
            s[y][target1] = (byte) ((byte) res1 & res2);//anding them means, index1 to index2 will be 1 inclusive, and others will be 0. Don't confuse with the example above, because index1 and index2 won't be same everytime, when they are the same, the length of the line will be 0 either way.
        } else {
            s[y][target1] = (byte)~(-1 << (8 - index1));
            ++index2;//to make the right border inclusive
            s[y][target2] = (byte)(-1 << (8 - index2));
        }
        
        
        //Print the screen out
        System.out.print(" ");
        for (i = 0; i < s[0].length * 8; ++i) {
            System.out.print("-");
        }
        System.out.println();
        for (byte[] bs : s) {
            System.out.print("|");
            for (byte b : bs) {
                String res = Integer.toBinaryString(b);
                if (res.equals("0"))//If it's 0 java prints 0, but we want it to take the full width(8) to have a nice screen
                    res = "00000000";
                if (res.length() < 8) {//Java deletes 0s that are at the start, we add them back
                    while (res.length() != 8) {
                        res = "0" + res;//I know StringBuilder would be more efficient.
                    }
                }
                //Since Integer.toBinaryString() returns 32 bits, we shrink them down to 8
                System.out.print(res.substring(res.length()-8));
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(" ");
        for (i = 0; i < s[0].length * 8; ++i) {
            System.out.print("-");
        }
    }
}
