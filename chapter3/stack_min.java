import java.util.Arrays;
import java.util.Random;
public class stack_min {
    public static void main(String[] args) {
        StackNode top = new StackNode(1000);
        StackwMin s = new StackwMin(top);
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; ++i) {
            Random r = new Random();
            int randomint = r.nextInt(999999999);
            if (i == 0) {//Just to delete 1000 there
                s.pop();
            }
            s.push(randomint);
            arr[i] = randomint;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
        System.out.println(s.getMin());
        System.out.println(arr[0] == s.getMin().val ? "Min function works as intended" : "Min function DOESN'T work.");
    }
    public static void printarr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(i != arr.length - 1 ? (arr[i] + ", ") : (arr[i]));
        }
        System.out.println("]");
    }
}

class StackNode {
    int val;
    StackNode next;

    StackNode(int valint) {
        val = valint;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
class StackwMin {
    StackNode top;
    Stack mins;

    StackwMin(StackNode top) {
        this.top = top;
        this.mins = new Stack(top);
    }

    public StackNode pop() {
        if (mins.isEmpty()) {
            throw new RuntimeException("Stack(mins) is empty!");
        } else {
            if (this.peek().val == mins.peek().val) {
                mins.pop();
            }
        }
        StackNode temp = null;
        if (this.top != null){
            temp = this.top;
            if (this.top.next != null) {
                this.top = this.top.next;
            } else {
                this.top = null;
            }
        }
        return temp;
    }

    public void push(StackNode item) {
        if (mins.isEmpty()) {
            throw new RuntimeException("Stack(mins) is empty!");
        } else {
            if (item.val < mins.peek().val) {
                mins.push(item);
            }
        }

        item.next = this.top;
        this.top = item;
    }

    public void push(int valint) {
        StackNode item = new StackNode(valint);
        if (mins.isEmpty()) {
            mins.push(item);
        } else {
            if (item.val < mins.peek().val) {
                mins.push(item);
            }
        }
        item.next = this.top;
        this.top = item;
    }

    public StackNode peek() {
        return this.top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public StackNode getMin() {
        return mins.peek();
    }

    @Override
    public String toString() {
        String res = "";
        StackNode p = this.top;
        while (p != null) {
            res += p.val + " > ";
            p = p.next;
        }
        return res;
    }
}
class Stack {
    StackNode top;

    Stack(StackNode top) {
        this.top = top;
    }

    public StackNode pop() {
        StackNode temp = null;
        if (this.top != null){
            temp = this.top;
            if (this.top.next != null) {
                this.top = this.top.next;
            } else {
                this.top = null;
            }
        }
        return temp;
    }

    public void push(StackNode item) {
        item.next = this.top;
        this.top = item;
    }

    public void push(int valint) {
        StackNode item = new StackNode(valint);
        item.next = this.top;
        this.top = item;
    }

    public StackNode peek() {
        return this.top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String res = "";
        StackNode p = this.top;
        while (p != null) {
            res += p.val + " > ";
            p = p.next;
        }
        return res;
    }
}