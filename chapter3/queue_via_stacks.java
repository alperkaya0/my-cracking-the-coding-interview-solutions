public class queue_via_stacks {
    public static void main(String[] args) {
        Queue_via_Stacks q = new Queue_via_Stacks();
        q.add(new StackNode(1));
        q.add(new StackNode(2));
        q.add(new StackNode(3));
        q.add(new StackNode(4));
        System.out.println(q.peek());
        System.out.println(q);
    }
}

class Queue_via_Stacks {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    //add
    public void add(StackNode item) {
        stack1.push(item);
    }
    //remove
    public StackNode remove() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        StackNode res = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
    //peek
    public StackNode peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        StackNode res = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
    //isEmpty
    public boolean isEmpty() {
        return stack1.top == null && stack2.top == null;
    }

    @Override
    public String toString() {
        StackNode p = stack1.top;
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        String res = "";
        p = stack2.top;
        while (p != null) {
            res += p.val + " > ";
            p = p.next;
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
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
        this.mins = new Stack();
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

    Stack() {

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