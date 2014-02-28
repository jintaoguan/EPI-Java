// Problem 6.3
// Design an algorithm that takes a sequence of n three-dimentional
// coordinates to be traversed, and return the minimum battery capacity needed to
// complete the journey. The robot begins with a fully charged battery.


public class Solution {
    
    public int find_battery_capacity(int[] A) {
        if( A.length <= 1 ) return 0; 
        int maxDiff = 0;
        int minHeight = A[0];
        for( int i = 1; i < A.length; ++i ) {
            // update the diff to min height
            maxDiff = Math.max( maxDiff, A[i] - minHeight );
            // update min height
            minHeight = Math.min( A[i], minHeight );
        }
    }
}
