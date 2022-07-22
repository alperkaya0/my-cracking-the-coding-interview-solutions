public class queue {
    public static void main(String[] args) {
        QueueNode toppu = new QueueNode("1");
        Queue queue = new Queue(toppu);
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.add("1");
        System.out.println(queue);
        queue.add("2");
        System.out.println(queue);
        queue.add("3");
        System.out.println(queue);
        queue.add("4");
        System.out.println(queue);
        queue.add("5");
        System.out.println(queue);
    }
}


class QueueNode {
    String val;
    QueueNode next;

    QueueNode(String val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        return this.val;
    }
}
class Queue {
    QueueNode top;
    QueueNode last;

    Queue(QueueNode top) {
        this.top = top;
        top.next = last;
    }

    public void add(QueueNode item) {
        if (top != null) {
            if (last == null) {
                last = item;
                top.next = last;
            } else {
                last.next = item;
                last = item;
            }
        } else {
            top = item;
            last = null;
            top.next = last;
        }
    }

    public void add(String val) {
        QueueNode item = new QueueNode(val);
        if (top != null) {
            if (last == null) {
                last = item;
                top.next = last;
            } else {
                last.next = item;
                last = item;
            }
        } else {
            top = item;
            last = null;
            top.next = last;
        }
    }

    public void remove() {
        this.top = this.top.next;
    }

    public QueueNode peek() {
        return this.top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String res = "";
        QueueNode p = this.top;

        while (p != null) {
            res += p.val + " > ";
            p = p.next;
        }

        return res;
    }
}
