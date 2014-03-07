// Problem 9.13
// Given two nodes in a binary tree T, design an algorithm that computes
// their LCA. Assume that each node has a parent pointer. The tree has n nodes and height h.
// Your algorithm should run in O(1) space and O(h) time.

public class problem_09_13 {

    public TreeNode findLCA( TreeNode a, TreeNode b) {
        int depthA = getHeight(a);
        int depthB = getHeight(b);
        if(depthA < depthB) {
            TreeNode tmp = a;
            a = b;
            b = tmp;
        }
        int depthDiff = Math.abs(depthA - depthB);
        while( depthDiff > 0 ) {
            a = a.parent;
            depthDiff = depthDiff - 1;
        }
        while( a != b ) {
            a = a.parent;
            b = b.parent;
        }
        return a;
    }

    public int getHeight(TreeNode node){
        TreeNode cur = node;
        int depth = 0;
        while( cur != null )  {
            depth = depth + 1;
            cur = cur.parent;
        }
        return depth;
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_13 solutions = new problem_09_13();

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
        
        
        System.out.println(solutions.findLCA(t3,t5).data);

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
