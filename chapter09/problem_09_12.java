// Problem 9.12
// Design an efficient algorithm for computing the LCA of nodes a
// and b in binary tree in which nodes do not have a parent pointer.

import java.util.ArrayList;

public class problem_09_12 {

    // 1. first solution
    public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if( root == null || a == null || b == null )
            return null;
        if( isAncester(root.left, a) && isAncester(root.left, b) )
            return findLCA(root.left, a, b);
        else if( isAncester(root.right, a) && isAncester(root.right,b) )
            return findLCA(root.right, a, b);
        else 
            return root;
    }

    public boolean isAncester(TreeNode root, TreeNode node) {
        if( root == null ) 
            return false;
        else if( root == node ) 
            return true;
        return (isAncester(root.left, node) || isAncester(root.right, node) );
    }

    // 2. second solution from EPI
    // I dont really understand this solution ...
    public TreeNode findLCA2(TreeNode root, TreeNode a, TreeNode b) {
        if( root == null )
            return null;
        else if( root == a || root == b )
            return root;
        TreeNode leftRes = findLCA2(root.left, a, b);
        TreeNode rightRes = findLCA2(root.right, a, b);
        if( leftRes != null && rightRes != null )
            return root;
        else if( leftRes != null )
            return leftRes;
        else
            return rightRes;
    }

    // 3. third solution, build the path from root to node
    public TreeNode findLCA3(TreeNode root, TreeNode a, TreeNode b) {
        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
        if( root == null || a == null || b == null )
            return null;
        findPath(root, a, path1);
        findPath(root, b, path2);
        int length1 = path1.size();
        int length2 = path2.size();
        TreeNode ans = null;
        for( int i = 0; i < Math.min(length1, length2); ++i ) {
            if( path1.get(i) == path2.get(i) )
                ans = path1.get(i);
            else 
                break;
        }
        return ans;
    }

    public boolean findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if( root == node )
            return true;
        path.add(root);
        boolean found = false;
        if(root.left != null) 
            found = findPath(root.left, node, path );
        if(root.right != null && found == false )
            found = findPath(root.right, node, path );
        if(found == false)
            path.remove(path.size() - 1);
        return found;
    }


    public static void main(String[] argv) {
        // unit test
        problem_09_12 solutions = new problem_09_12();

        //                1
        //        2               3
        //    4       5       6       7
        //                          8
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
        System.out.println(solutions.findLCA(t1,t6,t8).data);
        System.out.println(solutions.findLCA2(t1,t6,t8).data);
        System.out.println(solutions.findLCA3(t1,t6,t8).data);

    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
