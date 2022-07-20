package chapter2;

public class sum_lists {
    public static void main(String[] args) {
        LinkedList num1 = new LinkedList();
        Node n1 = new Node("6");
        Node n2 = new Node("1");
        Node n3 = new Node("7");
        n1.next = n2;
        n2.next = n3;
        num1.head = n1;
        System.out.println("Number 1: " + num1);

        LinkedList num2 = new LinkedList();
        Node sn1 = new Node("2");
        Node sn2 = new Node("9");
        Node sn3 = new Node("5");
        sn1.next = sn2;
        sn2.next = sn3;
        num2.head = sn1;
        System.out.println("Number 2: " + num2);

        sum_lists_followup_func(num1, num2);
    }
    public static void sum_lists_func(LinkedList num1, LinkedList num2) {
        int total1 = 0;
        int total2 = 0;
    
        Node p = num1.head;
        int quotient = 1;
        while (p != null) {
            total1 += Integer.parseInt(p.val) * quotient;
            p = p.next;
            quotient *= 10;
        }

        p = num2.head;
        quotient = 1;
        while (p != null) {
            total2 += Integer.parseInt(p.val) * quotient;
            p = p.next;
            quotient *= 10;
        }



        int end_total = total1 + total2;//Sorry for my naming convention
        System.out.println(total1 + " + " +  total2 + " = " + end_total);
        int tempvar = end_total;

        LinkedList result = new LinkedList();

        while(tempvar > 0) {
            int digit = tempvar % 10;
            tempvar /= 10;

            if (result.head == null) {
                result.head = new Node(String.valueOf(digit));
                result.tail = result.head;
                result.head.next = result.tail;
            }else {
                Node node = new Node(String.valueOf(digit));
                result.tail.next = node;
                result.tail = node;
            }
        }
        System.out.println(result);
    }
    public static void sum_lists_followup_func(LinkedList num1, LinkedList num2) {
        int total1 = 0;
        int total2 = 0;
        int len1 = 0;
        int len2 = 0;
        Node p = num1.head;

        while (p != null) {
            ++len1;
            p = p.next;
        }
        p = num1.head;

        double quotient = Math.pow(10, len1 - 1);
        while (p != null) {
            total1 += Integer.parseInt(p.val) * quotient;
            p = p.next;
            quotient /= 10;
        }

        p = num2.head;

        while (p != null) {
            ++len2;
            p = p.next;
        }
        p = num2.head;

        quotient = Math.pow(10, len2 - 1);
        while (p != null) {
            total2 += Integer.parseInt(p.val) * quotient;
            p = p.next;
            quotient /= 10;
        }


        int end_total = total1 + total2;//Sorry for my naming convention
        System.out.println(total1 + " + " +  total2 + " = " + end_total);
        int tempvar = Integer.parseInt(new StringBuilder(Integer.toString(end_total)).reverse().toString());

        LinkedList result = new LinkedList();

        while(tempvar > 0) {
            int digit = tempvar % 10;
            tempvar /= 10;

            if (result.head == null) {
                result.head = new Node(String.valueOf(digit));
                result.tail = result.head;
                result.head.next = result.tail;
            }else {
                Node node = new Node(String.valueOf(digit));
                result.tail.next = node;
                result.tail = node;
            }
        }
        System.out.println(result);
    }
}


class Node{
    String val;
    Node next;

    Node() {
        this.val = null;
        this.next = null;
    }
    Node(String val) {
        this.val = val;
        this.next = null;    
    }
    Node(String val, Node prev, Node next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList{
    Node head;
    Node tail;
    LinkedList() {
        this.head = null;
    }
    @Override
    public String toString() {
        String res = "";
        Node p = this.head;
        
        while (p != null) {
            res += p.val + " > ";
            p = p.next;
        }
        res += "END";
        return res;
    }
}