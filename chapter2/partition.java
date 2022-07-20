package chapter2;
public class partition {

    public static void main(String[] args) {
        //3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
        LinkedList ll = new LinkedList();
        Node n1 = new Node("3");
        Node n2 = new Node("5");
        Node n3 = new Node("8");
        Node n4 = new Node("5");
        Node n5 = new Node("10");
        Node n6 = new Node("2");
        Node n7 = new Node("1");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        n7.prev = n6;
        n6.prev = n5;
        n5.prev = n4;
        n4.prev = n3;
        n3.prev = n2;
        n2.prev = n1;

        ll.head = n1;
        ll.tail = n7;

        partition_func(ll, 5);
    }
    static public void partition_func(LinkedList ll, int k) {
        Node p = ll.head;
        Node bhead = new Node();
        Node btail = new Node();
        bhead.next = btail;
        LinkedList before = new LinkedList(bhead, btail);
        
        Node ahead = new Node();
        Node atail = new Node();
        ahead.next = atail;
        LinkedList after = new LinkedList(ahead, atail);

        while(p != null) {
            if (Integer.parseInt(p.val) >= k) {
                if (ahead.val == null) {
                    ahead.val = p.val;
                } else {
                    if (atail.val == null) {
                        atail.val = p.val;
                    } else {
                        Node temp = new Node(p.val);
                        after.tail.next = temp;
                        after.tail = temp;
                    }
                }
            }
            if (Integer.parseInt(p.val) < k) {
                if (bhead.val == null) {
                    bhead.val = p.val;
                } else {
                    if (btail.val == null) {
                        btail.val = p.val;
                    } else {
                        Node temp = new Node(p.val);
                        before.tail.next = temp;
                        before.tail = temp;
                    }
                }
            }
            p = p.next;
        }
        before.tail.next = after.head;

        p = before.head;

        while (p != null) {
            System.out.print(p.val + " > ");
            p = p.next;
        }
        System.out.print("END");
    }
}

class Node{
    String val;
    Node prev;
    Node next;

    Node() {
        this.val = null;
        this.prev = null;
        this.next = null;
    }
    Node(String val) {
        this.val = val;
        this.prev = null;
        this.next = null;    
    }
    Node(String val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LinkedList{
    Node head;
    Node tail;
    LinkedList() {
        this.head = null;
    }
    LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    @Override
    public String toString() {
        String res = "";
        Node p = this.head;
        
        while (p != null) {
            res += p.val + " > ";
            p = p.next;
        }

        return res;
    }
}