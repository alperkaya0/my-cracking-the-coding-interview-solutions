public class stack {
    public static void main(String[] args) {
        StackNode topNode = new StackNode("1");
        Stack stack = new Stack(topNode);
        System.out.println("Stack.top: " + stack.top);
        System.out.println("Stack.Peek(): " + stack.peek());
        stack.push("2");
        stack.push("3");
        System.out.println("Stack.toString(): " + stack);
        StackNode node = stack.pop();
        System.out.println("Stack.Pop(): " + node);
        System.out.println("Stack.toString(): " + stack);
        System.out.println("Stack.IsEmpty(): " + stack.isEmpty());
    }
}


class StackNode {
    String val;
    StackNode next;

    StackNode(String valString) {
        val = valString;
    }

    @Override
    public String toString() {
        return val;
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

    public void push(String valString) {
        StackNode item = new StackNode(valString);
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