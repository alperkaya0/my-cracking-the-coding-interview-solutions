import java.util.ArrayList;

public class successor {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        int[] arr = new int[]{5, 2, 7, 1, 3, 4, 6, 8, 9};
        for (int x : arr) {
            b.insert(new TreeNode(x));
        }
        System.out.println(b.arr);
        for (TreeNode node : b.arr) {
            System.out.println("This is the target: " + node);
            find_successor_func(node);
            System.out.println("~~~~~~~~~~~~~~");
        }
        inOrderTraversal(b.root);
    }
    public static void fix_visited(TreeNode root) {
        if (root == null) {
            return;
        }
        root.visited = false;
        fix_visited(root.children[0]);
        fix_visited(root.children[1]);   
    }
    public static void inOrderTraversal(TreeNode node) {
        if (node!= null) {
            inOrderTraversal(node.children[0]);
            System.out.println(node);
            inOrderTraversal(node.children[1]);
        }
    } 
    public static void find_successor_func(TreeNode root) {
        if (root == null) {
            System.out.println("There is no successor.");
            return;
        }
        if (root.children[1] != null) {
            //As given at hints, if there is a right subtree, then 
            //the answer the leftmost node of the right subtree.
            TreeNode pointer = root.children[1];

            while (pointer.children[0] != null) {
                pointer = pointer.children[0];
            }
            System.out.println("Successor: " + pointer.val);
        } else {
            //But if there is no right subtree, this means that we have finished traversing
            //left subtree of our parent, then we climb back to the top, and print our parent.
            TreeNode pointer = root;
            while (pointer.parent.children[1] == pointer) {
                pointer = pointer.parent;
                if (pointer.parent == null) {
                    break;
                }
            }
            pointer = pointer.parent;
            if (pointer != null) {
                System.out.println("Successor: " + pointer.val);
            } else {
                find_successor_func(pointer);//To decrease code-reuse
            }
        }
    }
}

class BinarySearchTree{
    TreeNode root;
    ArrayList<TreeNode> arr = new ArrayList<>();

    public void insert(TreeNode n) {
        if (root == null) {
            this.root = n;
            arr.add(n);
            return;
        }
        arr.add(n);
        if (n.val > this.root.val) {
            if (this.root.children[1] == null) {
                this.root.height++;
                this.root.xval++;
                this.root.children[1] = n;
                n.parent = this.root;
            } else {
                TreeNode pointer = root;

                while(pointer != null) {
                    pointer.xval++;
                    if (pointer.children[1] == null && n.val > pointer.val) {
                        pointer.children[1] = n;
                        n.parent = pointer;
                        break;
                    }if (pointer.children[0] == null && n.val <= pointer.val) {
                        pointer.children[0] = n;
                        n.parent = pointer;
                        break;
                    }
                    if (n.val > pointer.val)
                        pointer = pointer.children[1];
                    else {
                        pointer = pointer.children[0];
                    }    
                }
            }
        } else {
            if (this.root.children[0] == null) {
                this.root.height++;
                this.root.xval++;
                this.root.children[0] = n;
                n.parent = root;
            } else {
                TreeNode pointer = root;

                while(pointer != null) {
                    pointer.xval++;
                    if (pointer.children[1] == null && n.val > pointer.val) {
                        pointer.children[1] = n;
                        n.parent = pointer;
                        break;
                    }if (pointer.children[0] == null && n.val <= pointer.val) {
                        pointer.children[0] = n;
                        n.parent = pointer;
                        break;
                    }
                    if (n.val > pointer.val)
                        pointer = pointer.children[1];
                    else {
                        pointer = pointer.children[0];
                    }
                }
            }
        }
    }
}
class TreeNode {
    TreeNode[] children = new TreeNode[2];
    TreeNode parent;
    int val;
    int height = 1;
    int depth;
    boolean visited = false;
    int xval = 1;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}