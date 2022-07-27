import java.util.ArrayList;
import java.util.Arrays;

public class check_balanced {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        int[] arr = new int[9]; 
        for (int i = 1; i < 10; ++i) {
            arr[i - 1] = i;
        }
        Arrays.sort(arr);
        minimal_tree_func_w_bst(arr, b);
        //b.root.children[0].children[1] = null; //OPEN THESE TO GET A FALSE
        //b.root.children[0].children[0] = null;
        calculate_depth(b.root, 0);
        calculate_height(b.root);
        list_of_depths_func(b.root);
        System.out.println(check_balanced_func(b.root));
    }
    public static boolean check_balanced_func(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.children[0] != null && root.children[1] != null) {
            if (Math.abs(root.children[0].height - root.children[1].height) > 1) {
                return false;
            }
        } 
        if (root.children[0] == null && root.children[1] != null) {
            if (Math.abs(0 - root.children[1].height) > 1) {
                return false;
            }
        }
        if (root.children[0] == null && root.children[1] == null) {
            return true;
        }

        return check_balanced_func(root.children[0]) && check_balanced_func(root.children[1]);
    }
    public static void calculate_height(TreeNode root) {
        if (root == null) {
            return;
        }
        root.height = go_as_far_as_possible(root, 0);
        calculate_height(root.children[0]);
        calculate_height(root.children[1]);
    }
    public static void calculate_depth(TreeNode root, int depth) {
        if (root != null) {
            root.depth = depth;
        } else {
            return;
        }   
        ++depth;
        calculate_depth(root.children[0], depth);
        calculate_depth(root.children[1], depth);
        return;
    }
    public static ArrayList<ArrayList<TreeNode>> list_of_depths_func(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> arr = new ArrayList<>();
        ArrayList<TreeNode> q = new ArrayList<>();
        ArrayList<TreeNode> cu = new ArrayList<>();
        TreeNode node = root;
        q.add(node);

        for (int i = 0; i < q.size(); ++i) {
            node = q.get(i);
            if (!node.visited)
                cu.add(node);
            node.visited = true;

            if (node.children[0] != null) {
                if (!node.children[0].visited)
                    q.add(node.children[0]);
            }
            if (node.children[1] != null) {
                if (!node.children[1].visited)
                    q.add(node.children[1]);
            }
        }
        for (TreeNode treeNode : cu) {
            try {
                arr.get(treeNode.depth);
            } catch (IndexOutOfBoundsException e) {
                arr.add(treeNode.depth, new ArrayList<>());
            }
            arr.get(treeNode.depth).add(treeNode);
        }
        for (TreeNode treeNode : cu) {
            treeNode.depth = 0;
        }
        System.out.println(arr);
        return arr;
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
    public static void minimal_tree_func_w_bst(int[] arr, BinarySearchTree bst) {
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
        if (arr.length != 0)
            if (bst.root == null) {
                TreeNode root = new TreeNode(arr[mid]);
                bst.root = root;
            } else {
                bst.insert(new TreeNode(arr[mid]));
            }
        if (arr.length > 1) {
            minimal_tree_func_w_bst(Arrays.copyOfRange(arr, 0, mid), bst);
            minimal_tree_func_w_bst(Arrays.copyOfRange(arr, mid + 1, arr.length), bst);
        }
        
        return;
    }
    public static int go_as_far_as_possible(TreeNode root, int went) {
        if (root != null) {
            ++went;
        } else {
            return went;
        }
        return Math.max(go_as_far_as_possible(root.children[0], went), go_as_far_as_possible(root.children[1], went));
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