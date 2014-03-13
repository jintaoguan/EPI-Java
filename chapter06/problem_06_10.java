// Problem 6.10
// Given an array of n elements and a permutation TT, compute TT(A)
// using only constant additional storage. Use A itself to store the result.

public class problem_06_10 {
    
    // solution 1. use the sign bit of entries of the perm array
    public void apply_permutation1(int[] perm, int[] A) {
        // iterate the permutation cycle
        for( int i = 0; i < perm.length; ++i ) {
            if( perm[i] < 0 ) continue;
            int cur_idx = i;
            int cur_val = A[i];
            do {
                int to_idx = perm[cur_idx];
                int to_val = A[to_idx];
                A[to_idx] = cur_val;
                // mark this position as visited
                perm[cur_idx] = perm[cur_idx] - perm.length;
                cur_idx = to_idx;
                cur_val = to_val;
            } while( cur_idx != i );
        }
        // restore the perm
        for( int i = 0; i < perm.length; ++i )
            perm[i] = perm[i] + perm.length;
    }


    // solution 2. use O(1) storage but time complexity is O(n^2)
    public void apply_permutation2(int[] perm, int[] A) {
        for( int i = 0; i < A.length; ++i ) {
            boolean is_min = true;
            int j = perm[i];
            // traverse cycle first at the minimal position
            while( j != i ) {
                if( j < i ) {
                    is_min = false;
                    break;
                }
                j = perm[j];
            }
            // do swap from the minimal position
            if( is_min ) {
                int cur_idx = i;
                int cur_val = A[i];
                do {
                    int to_idx = perm[cur_idx];
                    int to_val = A[to_idx];
                    A[to_idx] = cur_val;
                    cur_idx = to_idx;
                    cur_val = to_val;
                } while( cur_idx != i );
            }
        }
    }

    public static void main(String[] argv) {
        problem_06_10 solutions = new problem_06_10();
        int[] a = new int[]{ 100, 200, 300, 400 };
        int[] perm = new int[]{ 2, 0, 1, 3 };
        solutions.apply_permutation2(perm, a); 
        for( int i = 0; i < a.length; ++i )
            System.out.print(a[i] + " ");

    }

}
