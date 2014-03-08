// Problem 9.7
// Design a function that efficiently computes the k-th node appearing
// in an inorder traversal. Specifically, your function should take as input a binary tree T
// and an integer K. Each node has a size field, which is the number of nodes in the subtree
// rooted at that node. What is the time complexity of your function?

public class problem_09_07 {

    // 1. iterative method
    public TreeNode find_kth_node_binary_tree(TreeNode root, int k) {
        TreeNode cur = root;
        while( cur != null ) {
            int leftSize = 0;
            if( cur.left != null ) 
                leftSize = root.left.size;
            if( k == leftSize + 1 )
                return cur;
            else if( k > leftSize + 1 ) {
                k = k - leftSize - 1;
                cur = cur.right;
            }
            else if( k <= leftSize ) {
                cur = cur.left;
            }
        }
        return null;
    }

    // 2. recursive method
    public TreeNode find_kth_node_binary_tree2(TreeNode root, int k) {
        if( k > root.size )
            return null;
        int leftSize = 0;
        if( root.left != null )
            leftSize = root.left.size;
        if( k == leftSize + 1 )
            return root;
        else if( k > leftSize + 1 )
            return find_kth_node_binary_tree2(root.right, k - leftSize - 1);
        else
            return find_kth_node_binary_tree2(root.left, k);
    }

    public static void main(String[] argv) {
        // unit test
        problem_09_07 solutions = new problem_09_07();
        
        TreeNode t1 = new TreeNode(1); t1.size = 7;
        TreeNode t2 = new TreeNode(2); t2.size = 2;
        TreeNode t3 = new TreeNode(3); t3.size = 4;
        TreeNode t4 = new TreeNode(4); t4.size = 1;
        TreeNode t5 = new TreeNode(5); t5.size = 2;
        TreeNode t6 = new TreeNode(6); t6.size = 1;
        TreeNode t7 = new TreeNode(7); t7.size = 1;
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t5.right = t7;

        // iterative method
        for( int i = 1; i <= 7; ++i ) {
            TreeNode ans1 = solutions.find_kth_node_binary_tree(t1, i);
            System.out.print(ans1.data + ",");
        }
        System.out.println();

        // recursive method
        for( int i = 1; i <= 7; ++i ) {
            TreeNode ans2 = solutions.find_kth_node_binary_tree2(t1, i);
            System.out.print(ans2.data + ",");
        }
        System.out.println();
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int size;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
