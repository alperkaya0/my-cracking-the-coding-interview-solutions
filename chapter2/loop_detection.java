package chapter2;
//THIS PIECE OF CODE WILL NOT ONLY BE USEFUL FOR YOUR INTERVIEWS, BUT AS A CODER YOU WILL NEED TO DETECT AND DEMOLISH UNINTENDED LOOPS WITH THE HELP OF THE COMPUTER, BECAUSE LINKEDLIST MAY BE VERY COMPLICATED AND LONG!
public class loop_detection {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node n1 = new Node("a");
        Node n2 = new Node("b");
        Node n3 = new Node("c");
        Node n4 = new Node("d");
        Node n5 = new Node("e");
        Node n6 = new Node("f");

        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        loop_detection_func(ll);
    }
    public static void loop_detection_func(LinkedList ll) {
        Node ps = ll.head;//slow pointer
        Node pf = ll.head;//fast pointer
        do {
            ps = ps.next;
            pf = pf.next;
            pf = pf.next;
        }while (ps != pf);

        System.out.println("There is a loop, proof:" + ps.val + " == " + pf.val);

        ps = ll.head;
        while (ps != pf) {
            ps = ps.next;
            pf = pf.next;
        }

        System.out.println("Start of the loop: " + ps.val);
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