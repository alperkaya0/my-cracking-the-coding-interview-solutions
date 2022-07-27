import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class paths_w_sums2 {
    public static void main(String[] args) {
        int target = 5;//change here if you want

        int[] arr1 = new int[9];
        for (int i = 1; i < 10; ++i) {
            arr1[i-1] = i;
        }
        TreeNode root = minimal_tree_func(arr1);
        ArrayList<String> arr = new ArrayList<>();
        dfs(root, arr, "");

        ArrayList<LinkedList> array = new ArrayList<>();
        for (String s : arr) {
            String[] sarr = s.split(">");
            array.add(new LinkedList());
            for (String salt : sarr) {
                if (salt != "")
                    array.get(array.size() - 1).add(new Node(salt));
            }
        }
        HashMap<Integer, Integer> counts = new HashMap<>();
        ArrayList<LinkedList> paths = new ArrayList<>();
        HashMap<String, Boolean> a = new HashMap<>();
        for (LinkedList linkedList : array) {
            recurse(linkedList, paths);
        }
        for (LinkedList linkedList : paths) {
            int temp = 0;
            Node p = linkedList.head;
            if (a.get(linkedList.toString()) == null) {
                a.put(linkedList.toString(), false);
            }
            if (a.get(linkedList.toString()) == false) {
                while(p != null) {
                    temp += Integer.valueOf(p.val);
                    p = p.next;
                }
                counts.put(temp, counts.get(temp) == null ? 1 : counts.get(temp) + 1);
            }
            a.put(linkedList.toString(), true);
        }
        System.out.println("There are " + counts.get(target) + " path(s) that sum to " + target + ".");
    }
    public static void recurse(LinkedList ll, ArrayList<LinkedList> paths) {
        if (ll.isEmpty()) {
            return;
        }
        paths.add(ll);
        
        LinkedList llh = ll.copy();
        llh.remove_head();
        recurse(llh, paths);//removed from head

        LinkedList llt = ll.copy();
        llt.remove_last();
        recurse(llt, paths);//removed from tail(last)
    }
    public static void fix_visited(TreeNode root) {
        if (root == null) {
            return;
        }
        root.visited = false;
        fix_visited(root.children[0]);
        fix_visited(root.children[1]);   
    }
    public static void paths_w_sums2_func() {
        
    }
    public static void dfs(TreeNode root, ArrayList<String> arr, String s) {
        if (root == null) {
            return;
        }
        root.visited = true;
        s += root.val + ">";

        if (root.children[0] == null && root.children[1] == null) {
            arr.add(s);
        }

        if (root.children[0] != null) {
            if (!root.children[0].visited) {
                dfs(root.children[0], arr, s);
            }
        }
        if (root.children[1] != null) {
            if (!root.children[1].visited) {
                dfs(root.children[1], arr, s);
            }
        }
        //
    }
    public static TreeNode minimal_tree_func(int[] arr) {
        int mid;
        if (arr.length % 2 == 1) {
            mid = arr.length / 2;
        } else {
            if (arr.length / 2 > 0) {
                mid = arr.length / 2 - 1;
            } else {
                mid = arr.length / 2;
            }
        }
        
        TreeNode root = null;
        if (arr.length != 0) {
            root = new TreeNode(arr[mid]);
        }
        if (arr.length > 1) {
            root.children[0] = minimal_tree_func(Arrays.copyOfRange(arr, 0, mid));
            root.children[1] = minimal_tree_func(Arrays.copyOfRange(arr, mid + 1, arr.length));
        }
        
        return root;
    }
}

class TreeNode {
    TreeNode[] children = new TreeNode[2];
    int val;
    boolean visited = false;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
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
    Node last;

    LinkedList() {
        this.head = null;
    }
    LinkedList(Node head) {
        this.head = head;
    }
    public LinkedList copy() {
        LinkedList cp = new LinkedList();
        Node p = this.head;

        while (p != null) {
            Node tmp = new Node(p.val);
            cp.add(tmp);
            p = p.next;
        }

        return cp;
    }
    public void add_head(Node n) {
        n.next = this.head;
        if (this.head != null) {
            this.head.prev = n;
        }
        this.head = n;
    }
    public Node remove_head() {
        Node temp = this.head;
        if (head != null && head.next != null)
            head.next.prev = null;
        if (head != null)
            this.head = head.next;
        if (head == null && last != null) {
            temp = last;
            this.last = null;
        }
        return temp;
    }
    //I don't have an add_last method because essentially it's the same as add()
    public Node remove_last() {
        Node temp = this.last;
        if (this.last != null && this.last.prev != null)
            last.prev.next = null;
        if (this.last != null) {
            this.last = last.prev;
        }    
        if (this.last == null && this.head != null) {
            temp = this.head;
            this.head = null;    
        }
        return temp;
    }
    public boolean isEmpty() {
        return this.head == null && this.last == null;
    }
    public void add(Node n) {
        if (head == null && last == null) {
            this.head = n;
        } else if (head == null && last != null) {
            this.head = n;
            this.head.next = last;
            this.last.prev = this.head;
        } else if (head != null && last == null) {
            this.last = n;
            this.head.next = this.last;
            this.last.prev = this.head;
        } else {
            this.last.next = n;
            n.prev = this.last;
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