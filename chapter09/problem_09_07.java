
public class problem_09_07 {

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

    public static void main(String[] argv) {
        // unit test
        problem_09_07 solutions = new problem_09_07();

    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int size;
    public int data;
    public TreeNode(int v) { data = v; left = null; right = null; }
}
