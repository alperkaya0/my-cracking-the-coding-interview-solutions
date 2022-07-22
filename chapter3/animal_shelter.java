import java.util.Random;

public class animal_shelter {
    public static void main(String[] args) {
        AnimalShelter sh = new AnimalShelter();
        Node cat1 = new Node("neko1");
        Node cat2 = new Node("neko2");
        Node dog1 = new Node("dog1");
        Node dog2 = new Node("dog2");
        sh.enqueue(cat1, true);
        sh.enqueue(cat2, true);
        sh.enqueue(dog1, false);
        sh.enqueue(dog2, false);
        System.out.println(sh.dequeueAny());
        System.out.println(sh.dequeueAny());
        System.out.println(sh.dequeueCat());
    }
}


class AnimalShelter {
    LinkedList cats;
    LinkedList dogs;

    AnimalShelter() {
        cats = new LinkedList();
        dogs = new LinkedList();
    }

    public void enqueue(Node n, boolean cat_or_not) {
        if (cat_or_not) {
            this.cats.add(n);
        }else {
            this.dogs.add(n);
        }
    }

    public Node dequeueAny() {
        Node res = new Node();
        if (cats.length > dogs.length) {//The one list that is longer will have the pet that is older
            res = cats.pop();
        } else if (cats.length < dogs.length) {
            res = dogs.pop();
        } else {
            Random r = new Random();
            int i = r.nextInt(2);
            if (i == 0) {
                res = cats.pop();
            } else {
                res = dogs.pop();
            }
        }
        return res;
    }

    public Node dequeueDog() {
        return dogs.pop();
    }

    public Node dequeueCat() {
        return cats.pop();
    }
}
class Node {
    String val;
    Node prev;

    Node(String val) {
        this.val = val;
    }
    Node () {

    }

    @Override
    public String toString() {
        return this.val;
    }
}
class LinkedList {//Singly
    int length = 0;
    Node last;//tail
    Node head;

    public void add(Node n) {
        if (last == null) {
            last = n;
        } else if (head == null) {
            head = n;
            last.prev = head;
        } else {
            head.prev = n;
            head = n;
        }
        length++;
    }

    public Node pop() {
        Node res = last;
        last = last.prev;
        length--;
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        Node p = this.last;

        while(p != null) {
            res = p.val + " < " + res;
            p = p.prev;
        }
        res = res + "Starts here";
        return res;
    }
}