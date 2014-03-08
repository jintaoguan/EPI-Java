// Problem 9.14
// Design an algorithm for computing the LCA of a and b that has time
// complexity O( max(d(a) - d(l), d(b) - d(l)) ). What is the worst-case time
// and space complexity of your algorithm?

import java.util.HashSet;

public class problem_09_14 {

    public TreeNode findLCA( TreeNode a, TreeNode b) {
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        while( a != null || b != null ) {
            if( a != null ) {
                if( set.contains(a) )
                    return a;
                else
                    set.add(a);
                a = a.parent;
            }
            if( b != null ) {
                if( set.contains(b) ) 
                    return b;
                else
                    set.add(b);
                b = b.parent;
            }
        }
        return null;
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_14 solutions = new problem_09_14();

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
        t1.addLeftChild(t2);
        t1.addRightChild(t3);
        t2.addLeftChild(t4);
        t2.addRightChild(t5);
        t3.addLeftChild(t6);
        t3.addRightChild(t7);
        t7.addLeftChild(t8);
        
        
        System.out.println(solutions.findLCA(t6,t8).data);

    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }


    public void addLeftChild(TreeNode child) {
        left = child;
        child.parent = this;
    }
    public void addRightChild(TreeNode child) {
        right = child;
        child.parent = this;
    }

}
