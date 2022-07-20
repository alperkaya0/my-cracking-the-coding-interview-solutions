package chapter2;
public class palindrome {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node n1 = new Node("d");
        Node n2 = new Node("e");
        Node n3 = new Node("i");
        Node n4 = new Node("f");
        Node n5 = new Node("i");
        Node n6 = new Node("e");
        Node n7 = new Node("d");
        ll.head = n1;
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
        ll.tail = n7;

        palindrome_func(ll);
    }
    public static boolean palindrome_func(LinkedList ll) {
        Node h = ll.head;
        Node t = ll.tail;
        Node p = ll.head;
        boolean res = true;
        boolean length = false;//false means even, true means odd
        while (p != null) {
            p = p.next;
            length = !length;
        }
        if (length) {
            while (h != t) {//if length is odd
                if (!h.val.equals(t.val)) {
                    res = false;
                    break;
                }
                h = h.next;
                t = t.prev;
            }
        } else {// if length is even
            while (h != null && t != null) {
                if (!h.val.equals(t.val)) {
                    res = false;
                    break;
                }
                h = h.next;
                t = t.prev;
            }
        }
        
        System.out.println(res);
        return res;
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