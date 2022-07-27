import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class minimal_tree {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 1; i < 10; ++i) {
            arr[i-1] = i;
        }
        TreeNode root = minimal_tree_func(arr);

        int height = (int) Math.floor(Math.log10(arr.length) / Math.log10(2)) + 1;
        
        printtree(root, height);
    }

    public static void printtree(TreeNode root, int height) {
        ArrayList<TreeNode> q = new ArrayList<>();
        ArrayList<ArrayList<TreeNode>> linked = new ArrayList<>();
        HashSet<TreeNode> s = new HashSet<>();
        String res = stringmultiplier("\t", height) + root.val;
        --height;
        q.add(root);
        int nexttarget = (root.children[0] != null ? 1 : 0) + (root.children[1] != null ? 1 : 0);
        while (!q.isEmpty()) {
            TreeNode node = q.remove(0);
            if (node.children[0] != null) {
                q.add(node.children[0]);
            }
            if (node.children[1] != null) {
                q.add(node.children[1]);
            }
            if (q.size() == nexttarget) {
                linked.add(new ArrayList<>());
                for (TreeNode n : q) {
                    if (!s.contains(n))
                        linked.get(linked.size() - 1).add(n);
                    s.add(n);
                }
                //calculate the next next target
                nexttarget = 0;
                for (TreeNode n : q) {
                    for (TreeNode n_alt : n.children) {
                        nexttarget += (n_alt != null ? 1 : 0);
                    }
                }
            }
        }
        for (ArrayList<TreeNode> a: linked) {
            res += "\n";
            for (TreeNode node : a) {
                if ((res.length() > 0 && res.charAt(res.length()-1) == '\n') || res.equals("")) {
                    res += stringmultiplier("\t", height) + node.val + "\t";
                } else {
                    res += "\t"  + node.val + "\t";
                }
            }
            --height;
        }
        System.out.println(res);
        linked.add(0, new ArrayList<TreeNode>());
        linked.get(0).add(root);
        System.out.println(linked);
    }
    public static String stringmultiplier(String s, int m) {
        String r = "";
        for (int i = 0; i < m; i++) {
            r += s;
        }
        return r;
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

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}