package chapter2;

public class intersection {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");
        Node n7 = new Node("7");
        ll1.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        LinkedList ll2 = new LinkedList();
        Node n12 = new Node("1");
        Node n22 = new Node("2");
        Node n32 = new Node("3");

        ll2.head = n12;
        n12.next = n22;
        n22.next = n32;
        n32.next = n4;

        System.out.println(ll1);
        System.out.println(ll2);
        
        intersection_func(ll1, ll2);
    }
    public static void intersection_func(LinkedList ll1, LinkedList ll2) {
        Node p1 = ll1.head;
        Node p2 = ll2.head;
        int l1 = 0;
        int l2 = 0;
        while (p1 != null) {
            ++l1;
            p1 = p1.next;
        }
        while (p2 != null) {
            ++l2;
            p2 = p2.next;
        }
        p1 = ll1.head;
        p2 = ll2.head;
        
        if (l1 > l2) {
            while (l1 != l2) {
                p1 = p1.next;
                --l1;
            }
        }else if (l2 > l1) {
            while (l1 != l2) {
                p2 = p2.next;
                --l2;
            }
        }else {
            while (p1 != null && p2 != null && p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            System.out.println(p1.val);
        }
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