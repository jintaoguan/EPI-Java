// Problem 6.4
// For each of the following, A is an integer array of length n
// (1) Compute the maximum value of ( A[j0] - A[i0] ) + ( A[j1] - A[i1] ),
//     subject to i0 < j0 < i1 < j1.
// (2) Compute the maximum value of ( A[j0] - A[i0] ) + ( A[j1] - A[i1] ) + ...
//     + ( A[jk-1] - A[ik-1] ), subject to i0 < j0 < i1 < j1 < ... < jk-1 < ik-1
// (3) Repeat (2) when k can be chosen to be any value from 0 to n/2

public class problem_06_04 {

    // solution for problem (1)
    public int find_max_two_pairs( int[] A ) {
        if( A.length <= 1 ) 
            return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        left[0] = 0;
        int min = A[0];
        for( int i = 1; i < A.length; ++i ) {
            left[i] = Math.max( left[i-1], A[i] - min );
            min = Math.min( A[i], min );
        }

        int max = A[A.length - 1];
        for( int i = A.length - 2; i >= 0; --i ) {
            right[i] = Math.max( right[i+1], max - A[i] );
            max = Math.max( A[i], max );
        }


        int maxprofit = 0;
        for( int i = 0; i < A.length; ++i ) {
            maxprofit = Math.max( maxprofit, right[i] + left[i] );
        }

        return maxprofit;
    }

    // solution for problem (2)
    public int find_max_k_pairs( int[] A, int k ) {
        int[][] dp = new int[k+1][A.length+1];

        int[] arr = new int[A.length+1];
        arr[0] = 0;
        for( int i = 1; i <= A.length; ++i )
            arr[i] = A[i-1];
        for( int i = 0; i <= k; ++i ) {
            dp[i][0] = 0;
            dp[i][1] = 0;
        }
        for( int i = 0; i <= A.length; ++i ) {
            dp[0][i] = 0;
        }

        for( int i = 1; i <= k; ++i ) {
            int max = dp[i-1][1] - arr[1];
            for( int j = 2; j <= A.length; ++j ) {
                // option 1: dp[i][j-1]
                // option 2: dp[i-1][k] - arr[k] + arr[j], subject to 1 <= k < j
                dp[i][j] = Math.max( dp[i][j-1], max + arr[j] );
                max = Math.max( max, dp[i-1][j] - arr[j] );
            }
        }

        return dp[k][A.length];
    }

    // ERROR 
    // another format of solution for problem (2)
    public int find_max_k_pairs2( int[] A, int k ) {

        int[][] dp = new int[A.length+1][k+1];
        int[] arr = new int[A.length+1];
        arr[0] = 0;

        for( int i = 1; i <= A.length; ++i )
            arr[i] = A[i-1];

        for( int i = 0; i <= k; ++i ) {
            dp[0][i] = 0;
            dp[1][i] = 0;
        }
        for( int i = 0; i <= A.length; ++i ) {
            dp[i][0] = 0;
        }

        for( int i = 1; i <= k; ++i ) {
            int max = dp[1][i-1] - arr[1];
            for( int j = 2; j <= A.length; ++j ) {
                dp[i][j] = Math.max( dp[j-1][i], max + arr[j] );
                max = Math.max( max, dp[j][i-1] - arr[j] );
            }
        }
        return dp[A.length][k];
    }

    // solution for problem (3)
    public int find_max_any_pairs( int[] prices ) {
        if( prices.length == 0 ) return 0;
        int profit = 0;
        for( int i = 0; i < prices.length - 1; ++i )
        {
            if( prices[i] < prices[i+1] )
                profit += prices[i+1] - prices[i];
        }
        return profit;
    }

    public static void main(String[] argv) {
        problem_06_04 solutions = new problem_06_04();
        int[] A = new int[]{ 1, -2, 2, 0, 3, 1, 2, 3 };
        System.out.println( solutions.find_max_two_pairs(A) );
        System.out.println( solutions.find_max_k_pairs(A,3) );
        System.out.println( solutions.find_sum_k_pairs2(A,3) );
    }

}
