// Problem 9.10
// Given a binary tree, write a function which forms a linked list from
// the leaves of the binary tree, The leaves should appear in left-to-right order.

import java.util.LinkedList;

public class problem_09_10 {

    public LinkedList<Integer> connect_leaves(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        connect_leaves_helper(root, ans);
        return ans;
    }
    
    public void connect_leaves_helper(TreeNode root, LinkedList<Integer> ans) {
        if( root == null ) return;
        connect_leaves_helper(root.left, ans);
        if( root.left == null && root.right == null )
            ans.add(root.data);
        connect_leaves_helper(root.right, ans);
    }

    // it is the same as above
    public void connect_leaves_helper2(TreeNode root, LinkedList<Integer> ans) {
        if( root == null ) return;
        if( root.left == null && root.right == null )
            ans.add(root.data);
        connect_leaves_helper2(root.left, ans);
        connect_leaves_helper2(root.right, ans);
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_10 solutions = new problem_09_10();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t7.left = t8;
        System.out.println(solutions.connect_leaves(t1));
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
