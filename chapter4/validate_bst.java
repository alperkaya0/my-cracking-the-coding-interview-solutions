import java.util.Arrays;

public class validate_bst {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 1; i < 10; ++i) {
            arr[i-1] = i;
        }
        TreeNode root = minimal_tree_func(arr, 0);//I've used this just to quickly create a binary tree

        System.out.println(validate_bst_func(root, null, null));
    }
    public static boolean validate_bst_func(TreeNode root, Integer min, Integer max) { // Book's Solution!
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min || max != null && root.val > max) {
            return false;
        }
        if (!validate_bst_func(root.children[0], min, Integer.valueOf(root.val)) || !validate_bst_func(root.children[1], Integer.valueOf(root.val), max)) {
            return false;
        }
        return true;
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


class TreeNode {
    TreeNode[] children = new TreeNode[2];
    int val;
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