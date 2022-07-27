import java.util.ArrayList;
import java.util.Arrays;

public class paths_w_sums {
    public static void main(String[] args) {
        //Thanks to bela for fixing my function.
        int[] arr1 = new int[9];
        for (int i = 1; i < 10; ++i) {
            arr1[i-1] = i;
        }
        TreeNode root = minimal_tree_func(arr1);
        int[] count = new int[]{0};
        paths_w_sums_func(root, count, 13);
        System.out.println(count[0]);
    }
    public static void fix_visited(TreeNode root) {
        if (root == null) {
            return;
        }
        root.visited = false;
        fix_visited(root.children[0]);
        fix_visited(root.children[1]);   
    }
    public static void paths_w_sums_func(TreeNode root, int[] count, int target) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> sums = new ArrayList<>();
        dfs(root, sums, 0);
        fix_visited(root);
        System.out.println(sums);
        for (Integer integer : sums) {
            if (integer == target) {
                count[0] += 1;
            }
        }
        paths_w_sums_func(root.children[0], count, target);
        paths_w_sums_func(root.children[1], count, target);
    }
    public static void dfs(TreeNode root, ArrayList<Integer> arr, int temp) {
        if (root == null) {
            return;
        }
        root.visited = true;
        temp += root.val;

        if (root.children[0] == null && root.children[1] == null) {
            arr.add(temp);
        }

        if (root.children[0] != null) {
            if (!root.children[0].visited) {
                dfs(root.children[0], arr, temp);
            }
        }
        if (root.children[1] != null) {
            if (!root.children[1].visited) {
                dfs(root.children[1], arr, temp);
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