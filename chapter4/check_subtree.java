public class check_subtree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        TreeNode children1 = new TreeNode(5);
        TreeNode children2 = new TreeNode(15);
        TreeNode root2 = new TreeNode(4);
        TreeNode children1_1 = new TreeNode(1);
        root1.children[0] = children1;
        root1.children[1] = children2;
        root1.children[0].children[0] = root2;
        root2.children[0] = children1_1;

        System.out.println(check_subtree_func(root1, root2));
    }
    public static boolean check_subtree_func(TreeNode t1, TreeNode t2) {
        //t1 is bigger
        //if the root of t2 equals with any node of the th1, then we don't need to check for other nodes...
        //...since we are checking with references not values
        return traverse(t1, t2);
    }
    public static boolean traverse(TreeNode root, TreeNode target) {
        if (root == target) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //I have used "or" operator since one "true" value is enough
        //Think this as: return false || false || false || false || (...) || true || false = true
        return traverse(root.children[0], target) || traverse(root.children[1], target);
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