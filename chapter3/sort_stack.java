import java.util.Arrays;
import java.util.Random;

public class sort_stack {
    public static void main(String[] args) {
        StackNode top = new StackNode(1);
        Stack original = new Stack(top);
        original.pop();
        int[] arr = new int[10];

        for (int i = 0; i < 10; ++i) {
            Random r = new Random();
            int randomint = r.nextInt(999);
            original.push(randomint);
            arr[i] = randomint;
        }
        /*My Sol
        Stack temp = new Stack();
        for (int i = 0; i < 10; ++i) {
            StackNode p = original.top;
            int max = original.top.val;
            while (p != null) {
                if (p.val > max) {
                    max = p.val;
                }
                p = p.next;
            }
            p = original.top;
            while (p != null) {
                if (p.val == max) {
                    p.val = p.next.val;
                    p.next = p.next.next;
                }
                p = p.next;
            }
            temp.push(max);
        }
        
        System.out.println(temp);
        */
        Arrays.sort(arr);
        printarr(arr);
        original.sort(original);
        System.out.println(original);
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
        if (!mins.isEmpty()) {
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
            mins.push(item);
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
    Stack() {
        top = null;
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
    //Book's solution
    public void sort(Stack s) {
        Stack r = new Stack();
        while(!s.isEmpty()) {
        /* Insert each element in s in sorted order into r. */
            int tmp = s.pop().val;
            while(!r.isEmpty() && r.peek().val > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        
        /* Copy the elements from r back into s. */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
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