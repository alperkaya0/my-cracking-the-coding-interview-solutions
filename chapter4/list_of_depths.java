import java.util.ArrayList;
import java.util.Arrays;

public class list_of_depths {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 1; i < 10; ++i) {
            arr[i-1] = i;
        }
        TreeNode root = minimal_tree_func(arr, 0);//I've used this just to quickly create a binary tree

        //We don't necessarily need height variable, but it's such a nice formula to note about.
        //int height = (int) Math.floor(Math.log10(arr.length) / Math.log10(2)) + 1;

        list_of_depths_func(root);
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