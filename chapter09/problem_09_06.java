// Problem 9.6
// Design an algorithm that takes a node n in a binary tree, and returns
// its successor, Assume that each node has a parent field; the parent
// field of root is null.

public class problem_09_06 {

    // inorder successor
    public TreeNode find_successor(TreeNode node) {
        TreeNode cur = node;
        if( cur.right != null ) {
            cur = cur.right;
            while( cur.left != null ) {
                cur = cur.left;
            }
            return cur;
        }
        // Find the first parent whose left child is cur node
        while( cur.parent != null && cur.parent.right == cur )
            cur = cur.parent;
        // Return null means cur node does not have a successor
        return cur.parent;
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_06 solutions = new problem_09_06();

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
        System.out.println(solutions.find_successor(t2).data);
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
