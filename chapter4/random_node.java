import java.util.Random;

public class random_node {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode children0 = new TreeNode(2);
        TreeNode children1 = new TreeNode(10);
        TreeNode children1_1 = new TreeNode(20);
        TreeNode children1_0 = new TreeNode(5);
        TreeNode anothernode = new TreeNode(1);
        BinarySearchTree b = new BinarySearchTree();

        b.root = root;
        b.insert(children0);
        b.insert(children1);
        b.insert(children1_0);
        b.insert(children1_1);
        b.insert(anothernode);
        
        //xval works until now, *which is number of nodes of a subtree
        double[] probs = new double[6];
        long try_num = 120000;//make it Long.MAX_VALUE if you want a more accurate result or, lower this value if you want a fast but inaccurate output
        
        for (long i = 0; i < try_num; ++i) {
            int temp = random_node_func(root).val;
            if (temp == 3) {
                probs[0] += 1;
            }
            if (temp == 2) {
                probs[1] += 1;
            }
            if (temp == 10) {
                probs[2] += 1;
            }
            if (temp == 20) {
                probs[3] += 1;
            }
            if (temp == 5) {
                probs[4] += 1;
            }
            if (temp == 1) {
                probs[5] += 1;
            }
        }

        //As you can observe, all of them are 0.1666X
        System.out.println("Probability of  3: " + probs[0] / try_num);
        System.out.println("Probability of  2: " + probs[1] / try_num);
        System.out.println("Probability of 10: " + probs[2] / try_num);
        System.out.println("Probability of 20: " + probs[3] / try_num);
        System.out.println("Probability of  5: " + probs[4] / try_num);
        System.out.println("Probability of  1: " + probs[5] / try_num);
    }
    public static TreeNode random_node_func(TreeNode root) {
        if (root.children[0] == null && root.children[1] == null) {
            return root;
        }
        Random r = new Random();
        int i = r.nextInt(root.xval);
        i += 1;
        if (root.children[0] != null) {
            int first = root.children[0].xval;
            int middle = 1;
            //int second = root.children[0].xval;
            middle += first;
            //second += first + 1;
    
            if (i <= first) {
                if (root.children[0] != null)
                    return random_node_func(root.children[0]);
                else
                    return root;
            }
            if (i == middle) {
                return root;
            }else {
                if (root.children[1] != null)
                    return random_node_func(root.children[1]);
                else
                    return root;
            }
        }else {
            int first = 0;
            int middle = 1;
            //int second = root.children[0].xval; //we don't need to calculate this
            middle += first;
            //second += first + 1; //only here to see the full picture

            if (i <= first) {
                if (root.children[0] != null)
                    return random_node_func(root.children[0]);
                else
                    return root;
            }
            if (i == middle) {
                return root;
            }else {
                if (root.children[1] != null)
                    return random_node_func(root.children[1]);
                else
                    return root;
            }
        }
        
    }
}
class BinarySearchTree{
    TreeNode root;

    public void insert(TreeNode n) {
        if (n.val > this.root.val) {
            if (this.root.children[1] == null) {
                this.root.height++;
                this.root.xval++;
                this.root.children[1] = n;
            } else {
                TreeNode pointer = root;

                while(pointer != null) {
                    pointer.xval++;
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
                this.root.xval++;
                this.root.children[0] = n;
            } else {
                TreeNode pointer = root;

                while(pointer != null) {
                    pointer.xval++;
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
    int xval = 1;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}