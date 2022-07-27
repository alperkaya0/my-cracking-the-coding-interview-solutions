import java.util.ArrayList;
import java.util.Arrays;

public class bst_sequences {
    public static void main(String[] args) {
        int[] arr = new int[9]; 
        for (int i = 1; i < 10; ++i) {
            arr[i - 1] = i;
        }
        Arrays.sort(arr);
        TreeNode root = minimal_tree_func(arr, 0);
        ArrayList<ArrayList<Integer>> arr1 = new ArrayList<>();
        arr1.add(new ArrayList<>());
        arr1.add(new ArrayList<>());
        bst_sequences_left_func(root, arr1);
        reset_visited(root);
        bst_sequences_right_func(root, arr1);
        System.out.println(arr1);
    }
    public static void reset_visited(TreeNode root) {
        if (root != null) {
            root.visited = false;
            reset_visited(root.children[0]);
            reset_visited(root.children[1]);
        }
    }
    public static void bst_sequences_left_func(TreeNode root, ArrayList<ArrayList<Integer>> array) {
        if (!root.visited) {
            array.get(0).add(root.val);
            root.visited = true;
        }
        if (root.children[0] != null) {
            if (!root.children[0].visited) {
                array.get(0).add(root.children[0].val);
                root.children[0].visited = true;
            }
        }
        if (root.children[1] != null) {
            if (!root.children[1].visited) {
                array.get(0).add(root.children[1].val);
                root.children[1].visited = true;
            }
        }
        if (root.children[0] != null)
            bst_sequences_left_func(root.children[0], array);
        if (root.children[1] != null)
            bst_sequences_left_func(root.children[1], array);
        
    }
    public static void bst_sequences_right_func(TreeNode root, ArrayList<ArrayList<Integer>> array) {
        if (!root.visited) {
            array.get(1).add(root.val);
            root.visited = true;
        }
        if (root.children[1] != null) {
            if (!root.children[1].visited) {
                array.get(1).add(root.children[1].val);
                root.children[1].visited = true;
            }
        }
        if (root.children[0] != null) {
            if (!root.children[0].visited) {
                array.get(1).add(root.children[0].val);
                root.children[0].visited = true;
            }
        }
        if (root.children[1] != null)
            bst_sequences_right_func(root.children[1], array);
        if (root.children[0] != null)
            bst_sequences_right_func(root.children[0], array);
    }
    public static TreeNode minimal_tree_func(int[] arr, int depth) {
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
            root.depth = depth;
        }
        if (arr.length > 1) {
            ++depth;
            root.children[0] = minimal_tree_func(Arrays.copyOfRange(arr, 0, mid), depth);
            root.children[1] = minimal_tree_func(Arrays.copyOfRange(arr, mid + 1, arr.length), depth);
        }
        
        return root;
    }
}

class BinarySearchTree{
    TreeNode root;

    public void insert(TreeNode n) {
        if (n.val > this.root.val) {
            if (this.root.children[1] == null) {
                this.root.height++;
                this.root.children[1] = n;
            } else {
                TreeNode pointer = root;

                while(pointer != null) {
                    if (pointer.children[1] == null && n.val > pointer.val) {
                        pointer.children[1] = n;
                        break;
                    }if (pointer.children[0] == null && n.val <= pointer.val) {
                        pointer.children[0] = n;
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
                this.root.children[0] = n;
            } else {
                TreeNode pointer = root;

                while(pointer != null) {
                    if (pointer.children[1] == null && n.val > pointer.val) {
                        pointer.children[1] = n;
                        break;
                    }if (pointer.children[0] == null && n.val <= pointer.val) {
                        pointer.children[0] = n;
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

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}