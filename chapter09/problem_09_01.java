// Problem 9.1
// Write a function that takes as input the root of a binary tree and
// returns true or false depending on whether the tree is balanced.
// Use O(h) additional storage, where it is the height of the tree. 
public class problem_09_01 {

    public boolean is_balanced_binary_tree(TreeNode root) {
        int height = get_height(root);
        if( height == -1 ) return false;
        return true;
    }

    public int get_height(TreeNode root) {
        if( root == null ) return 0;
        int lh = get_height(root.left);
        if( lh == -1 ) return -1;
        int rh = get_height(root.right);
        if( rh == -1 ) return -1;
        if( Math.abs(lh-rh) > 1 ) return -1;
        return Math.max(lh,rh) + 1;
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_01 solutions = new problem_09_01();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t2.left = t3;
        System.out.println(solutions.is_balanced_binary_tree(t1));

        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t4.left = t5;
        t4.right = t6;
        System.out.println(solutions.is_balanced_binary_tree(t4));



    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
