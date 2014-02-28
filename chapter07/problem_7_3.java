// Problem 7.3
// Write a function that takes a pointer to an arbitrary node in a sorted 
// circular linked list, and returns the median of the linked list.

public class Solution {

    public double find_median_sorted_circular_linked_list(ListNode head) {
        if( head == null )
            return 0;
        ListNode cur = head;
        ListNode start = head;
        int count = 0;
        // calculate the length of this list and identify the position of start
        do {
            count++;
            cur = cur.next;
            // identify the position of maximum element
            if( start.data <= cur.data ) {
                start = cur;
            }
        } while( cur != head );
        // the next position is minimum element
        start = start.next;

        for( int i = 0; i < (count-1)/2; ++i )
            start = start.next;
        // if the length is odd
        if( count % 2 == 1 )
            return start.data;
        // if the length is even
        return ( start.data + start.next.data ) / 2.0;
    }
}
