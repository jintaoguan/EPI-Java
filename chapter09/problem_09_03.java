// Problem 9.3
// Write a function that takes as input the root of a binary tree and
// returns true or false depending on whether the tree is symmetric.

public class problem_09_03 {

    public boolean is_symmetric(TreeNode root) {
        if( root == null ) return true;
        return is_symmetric_helper(root.left, root.right);
    }

    public boolean is_symmetric_helper(TreeNode node1, TreeNode node2) {
        if( node1 == null && node2 == null ) return true;
        if( node1 == null || node2 == null ) return false;
        if( node1.data != node2.data ) return false;
        boolean first = is_symmetric_helper(node1.left, node2.right);
        boolean second = is_symmetric_helper(node1.right, node2.left);
        return (first && second);
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_03 solutions = new problem_09_03();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        //t7.left = t8;
        System.out.println(solutions.is_symmetric(t1));

    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
