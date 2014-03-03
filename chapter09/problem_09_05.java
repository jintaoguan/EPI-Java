// Problem 9.5
// Let T be the root of a binary tree in which nodes have an explicit
// parent field. Design an iterative algorithm that enumerate the nodes inorder
// and uses O(1) additional space. Your algorithm cannot modify the tree.

import java.util.ArrayList;

public class problem_09_05 {

    // 1. recuesive solution
    public void inorder_traversal(TreeNode root, ArrayList<Integer> ans) {
        if( root == null ) return;
        inorder_traversal(root.left, ans);
        ans.add(root.data);
        inorder_traversal(root.right, ans);
    }

    // 2. iterative solution using parent reference
    public void inorder_traversal_parent(TreeNode root, ArrayList<Integer> ans) {
        if( root == null ) return;
        TreeNode prev = null;
        TreeNode cur = root;
        TreeNode next = null;

        while( cur != null ) {
            if( prev == null || prev.left == cur || prev.right == cur ) {
                if( cur.left != null ) {
                    next = cur.left;
                } else {
                    ans.add(cur.data);
                    next = ( cur.right == null ? cur.parent : cur.right );
                }
            } else if( cur.left  == prev ) {
                ans.add(cur.data);
                next = ( cur.right == null ? cur.parent : cur.right );
            } else if( cur.right == prev ) {
                next = cur.parent;
            }
            prev = cur;
            cur = next;
        }
    }


    // FOLLOW-UP. 
    // How would you perform preorder and postorder walks iteratively
    // using O(1) additional space? Your algorithm cannot modify the tree.
    // Nodes have an explicit parent field.


    // recursive method
    public void preorder_traversal(TreeNode root, ArrayList<Integer> ans) {
        if( root == null ) return;
        ans.add(root.data);
        preorder_traversal(root.left, ans);
        preorder_traversal(root.right, ans);
    }

    public void postorder_traversal(TreeNode root, ArrayList<Integer> ans) {
        if( root == null ) return;
        postorder_traversal(root.left, ans);
        postorder_traversal(root.right, ans);
        ans.add(root.data);
    }

    // iterative method
    public void preorder_traversal_parent(TreeNode root, ArrayList<Integer> ans) {
        if(root == null) return;
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode next = null;

        while( cur != null ) {
            if( prev == null || prev.left == cur || prev.right == cur ) {
                ans.add(cur.data);
                if( cur.left != null ) {
                    next = cur.left;
                } else if( cur.left == null ) {
                    next = ( cur.right == null ? cur.parent : cur.right );
                }
            } else if( cur.left == prev ) {
                next = ( cur.right == null ? cur.parent : cur.right );
            } else if( cur.right == prev ) {
                next = cur.parent;
            }
            prev = cur;
            cur = next;
        }
    }

    public void postorder_traversal_parent(TreeNode root, ArrayList<Integer> ans) {
        if(root == null) return;
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode next = null;

        while( cur != null ) {
            if( prev == null || prev.left == cur || prev.right == cur ) {
                if( cur.left != null ) {
                    next = cur.left;
                } else if( cur.left == null ) {
                    next = ( cur.right == null ? cur.parent : cur.right );
                    if( next == cur.parent ) {
                        ans.add(cur.data);
                    }
                }
            } else if( cur.left == prev ) {
                next = ( cur.right == null ? cur.parent : cur.right );
                if( next == cur.parent ) {
                    ans.add(cur.data);
                }
            } else if( cur.right == prev ) {
                ans.add(cur.data);
                next = cur.parent;
            }
            prev = cur;
            cur = next;
        }
    }


    public static void main(String[] argv) {
        // unit test
        problem_09_05 solutions = new problem_09_05();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.addLeftChild(t2);
        t1.addRightChild(t3);
        t2.addLeftChild(t4);
        t2.addRightChild(t5);
        t3.addLeftChild(t6);
        t3.addRightChild(t7);
        t7.addLeftChild(t8);
        // traverse using recursive method
        ArrayList<Integer> ans1 = new ArrayList<Integer>();
        solutions.postorder_traversal(t1, ans1);
        System.out.println(ans1);
        // traverse using iterative method
        ArrayList<Integer> ans2 = new ArrayList<Integer>();
        solutions.postorder_traversal_parent(t1, ans2);
        System.out.println(ans2);

    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int data;
    public TreeNode(int v) { data = v; parent = null; left = null; right = null; }
    
    public void addLeftChild(TreeNode child) {
        left = child;
        child.parent = this;
    }
    public void addRightChild(TreeNode child) {
        right = child;
        child.parent = this;
    }
}
