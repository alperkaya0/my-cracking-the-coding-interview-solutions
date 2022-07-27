public class breadth_first_search {
    public static void main(String[] args) {
        Graph g = new Graph();
        GraphNode r = new GraphNode(1);
            GraphNode two = new GraphNode(2);
            GraphNode three = new GraphNode(3);
                GraphNode threeandhalf = new GraphNode(35);
            GraphNode four = new GraphNode(4);
                GraphNode five = new GraphNode(5);
                GraphNode six = new GraphNode(6);
        LinkedList root = new LinkedList();
        Node tmp = new Node("2");
        tmp.storage = two;
        Node tmp2 = new Node("3");
        tmp2.storage = three;
        Node tmp3 = new Node("4");
        tmp3.storage = four;
        root.add(tmp);
        root.add(tmp2);
        root.add(tmp3);
        r.neighbours = root;

        LinkedList third = new LinkedList();
        Node tmp3point5 = new Node("3.5");
        tmp3point5.storage = threeandhalf;
        third.add(tmp3point5);
        three.neighbours = third;

        LinkedList fourth = new LinkedList();
        Node tmpf = new Node("5");
        tmpf.storage = five;
        Node tmpf1 = new Node("6");
        tmpf1.storage = six;
        fourth.add(tmpf);
        fourth.add(tmpf1);
        four.neighbours = fourth;

        g.root = r;
        g.bfs(g.root);
    }
}



class Graph {
    GraphNode root;

    public void find_if_there_is_a_route_with_bfs(GraphNode r, GraphNode t) {
        QueueNode n = new QueueNode("root");
        n.storage = r;
        Queue q = new Queue(n);
        Queue visited = new Queue();

        while (!q.isEmpty()) {
            GraphNode node = q.remove().storage;
            //visit(node); Representative visiting, it has no real effects
            QueueNode visitednode = new QueueNode("visitednode");
            visitednode.storage = node;
            visited.add(visitednode);
            if (node == t) {
                break;
            }
            if (node.neighbours != null) {
                Node pointer = node.neighbours.head;
                while (pointer != null) {
                    QueueNode temp = new QueueNode("");
                    temp.storage = pointer.storage;
                    q.add(temp);
                    pointer = pointer.next;
                }
            }
        }

        while (!visited.isEmpty()) {
            System.out.println(visited.remove().storage.val);
        }
    }
    public void bfs(GraphNode r) {
        QueueNode n = new QueueNode("root");
        n.storage = r;
        Queue q = new Queue(n);

        while (!q.isEmpty()) {
            GraphNode node = q.remove().storage;
            visit(node);
            if (node.neighbours != null) {
                Node pointer = node.neighbours.head;
                while (pointer != null) {
                    QueueNode temp = new QueueNode("");
                    temp.storage = pointer.storage;
                    q.add(temp);
                    pointer = pointer.next;
                }
            }
        }
    }
    public void visit(GraphNode n) {
        System.out.println(n.val);
    }
}
class GraphNode {
    int val;
    LinkedList neighbours;

    GraphNode(int val) {
        this.val = val;
    }
}
class QueueNode {
    String val;
    QueueNode next;
    GraphNode storage;//Because Node will store a GraphNode

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
    Queue() {

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

    public QueueNode remove() {
        QueueNode q = this.top;
        this.top = this.top.next;

        return q;
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
class Node{
    String val;
    Node prev;
    Node next;
    GraphNode storage;

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
    Node last;

    LinkedList() {
        this.head = null;
    }
    LinkedList(Node head) {
        this.head = head;
    }

    public void add(Node n) {
        if (head == null && last == null) {
            this.head = n;
        } else if (head == null && last != null) {
            this.head = n;
            this.head.next = last;
        } else if (head != null && last == null) {
            this.last = n;
            this.head.next = this.last;
        } else {
            this.last.next = n;
            this.last = n;
        }
        
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