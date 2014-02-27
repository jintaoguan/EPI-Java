// Problem 6.1
// Write a function that take an array A and an index i into A, and
// rearranges the elements such that all elements less than A[i] appear first, followed
// by elements equal to A[i], followed by elements greater than A[i]. Your algorithm
// should have O(1) space complexity and O(|A|) time complexity.

public class Solution {

    public void dutch_flag_partition(int[] A, int index) {
        if (index < 0 || index >= A.length)
            return;
        int pivot = A[index];
        int left = 0;
        int cur = 0;
        int right = A.length - 1;
        while (cur <= right) {
            if (A[cur] < pivot) {
                int tmp = A[cur];
                A[cur] = A[left];
                A[left] = tmp;
                left++;
                cur++;
            } else if (A[cur] == pivot) {
                cur++;
            } else if (A[cur] > pivot) {
                int tmp = A[cur];
                A[cur] = A[right];
                A[right] = tmp;
                right--;
            }
        }
    }
}
