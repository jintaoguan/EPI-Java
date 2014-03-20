// Problem 6.6
// Design and implement an algorithm that takes as input an array A of
// n elements, and returns the beginning and ending indices of a longest
// increasing subarray of A.

import java.util.ArrayList;

public class problem_06_06 {
    
    public ArrayList<Integer> find_LIS(int[] A) {
        int max_len = 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(0); ans.add(0);

        int i = 0;
        while( i < A.length ) {
            boolean is_skippable = false;
            for( int j = i + max_len - 1; j >= i; --j ) {
                if( j + 1 >= A.length || A[j] >= A[j+1] ) {
                    i = j + 1;
                    is_skippable = true;
                    break;
                }
            }

            if( is_skippable == false ) {
                i += max_len - 1;
                while( i + 1 < A.length && A[i] < A[i+1] ) {
                    ++i;
                    ++max_len;
                }
                ans.set(0, i - max_len + 1);
                ans.set(1, i);
            }
        }
        return ans;
    }

    public ArrayList<Integer> find_LIS2(int[] A) {
        return null;
    }


    public static void main(String[] argv) {
        problem_06_06 solutions = new problem_06_06();
        int[] a = new int[]{ 2,13,6,8,9,1 };
        System.out.println(solutions.find_LIS(a));


    }

}
