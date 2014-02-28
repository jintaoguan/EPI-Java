// Problem 7.1
// Write a function that takes L and F, and returns the merge of L 
// and F. Your code should use O(1) additional storage - it should reuse the nodes from 
// the lists provided as input. The only field you can change in a node is next.

public class Solution {
    public ListNode merge_sorted_linked_lists(ListNode F, ListNode L) {
        if (F == null && L == null)
            return null;
        if (F == null)
            return L;
        if (L == null)
            return F;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode l1 = F;
        ListNode l2 = L;
        int val1 = 0;
        int val2 = 0;
        while (l1 != null || l2 != null) {
            val1 = Integer.MAX_VALUE;
            val2 = Integer.MAX_VALUE;
            if( l1 != null ) val1 = l1.data;
            if( l2 != null ) val2 = l2.data;
            if( val1 < val2 ) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        return dummy.next;
    }
}
