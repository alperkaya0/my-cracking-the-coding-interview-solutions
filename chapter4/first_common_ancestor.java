import java.util.Arrays;

public class first_common_ancestor {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 1; i < 10; ++i) {
            arr[i-1] = i;
        }
        TreeNode root = minimal_tree_func(null, arr, 0);
        System.out.println(first_common_ancestor_func(root.children[0].children[0], root.children[0].children[1].children[1]));
    }
    public static boolean first_common_ancestor_func(TreeNode a, TreeNode b) {
        TreeNode p1 = a;
        TreeNode p2 = b;

        while (p1 != p2) {
            if (p1.depth > p2.depth) {
                while (p1.depth != p2.depth) {
                    p1 = p1.parent;
                }
            }
            if (p1.depth < p2.depth) {
                while (p1.depth != p2.depth) {
                    p2 = p2.parent;
                }
            }

            if (p1.parent != null)
                p1 = p1.parent;
            if (p2.parent != null)
                p2 = p2.parent;
        }

        if (p1 == p2) {
            System.out.println("First Common Ancestor: " + p1.val);
            return true;
        }

        return false;
    }
    public static TreeNode minimal_tree_func(TreeNode realroot, int[] arr, int depth) {
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
            root.parent = realroot;
            root.depth = depth;
        }
        if (arr.length > 1) {
            ++depth;
            root.children[0] = minimal_tree_func(root, Arrays.copyOfRange(arr, 0, mid), depth);
            root.children[1] = minimal_tree_func(root, Arrays.copyOfRange(arr, mid + 1, arr.length), depth);
        }
        
        return root;
    }
}
class TreeNode {
    TreeNode[] children = new TreeNode[2];
    int val;
    TreeNode parent;
    int depth;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}