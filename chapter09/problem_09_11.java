// Problem 9.11
// Write a function that prints the nodes on the exterrior of a binary tree in
// anti-clockwise order, i.e., print the nodes on the path from the root to the
// leftmost leaf in that order, then the leaves from left-to-right, then
// the nodes from the rightmost leaf up to the root.

import java.util.ArrayList;

public class problem_09_11 {

    public ArrayList<Integer> exterior_binary_tree(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if( root == null ) return ans;
        ans.add(root.data);
        left_boundary_b_tree(root.left, true, ans);
        right_boundary_b_tree(root.right, true,ans);
        return ans;
    }

    public void left_boundary_b_tree(TreeNode root, boolean is_boundary, ArrayList<Integer> ans) {
        if( root == null ) return;
        if( is_boundary ) 
            ans.add(root.data);
        else if( root.left == null && root.right == null )
            ans.add(root.data);
        left_boundary_b_tree( root.left, is_boundary, ans );
        right_boundary_b_tree( root.right, is_boundary && (root.left == null), ans );
    }

    public void right_boundary_b_tree(TreeNode root, boolean is_boundary, ArrayList<Integer> ans) {
        if( root == null ) return;
        right_boundary_b_tree(root.left, is_boundary &&(root.right == null), ans );
        right_boundary_b_tree(root.right, is_boundary, ans);
        if( is_boundary )
            ans.add(root.data);
        else if( root.left == null && root.right == null )
            ans.add(root.data);
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_11 solutions = new problem_09_11();

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
        System.out.println(solutions.exterior_binary_tree(t1));
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
