// Problem 7.2
// Given a reference to the head of a singly linked list L, how would you 
// determine wether L ends in a null or reaches a cycle of nodes? Write a function
// that returns null if there does not exist a cycle, and the reference to the start
// of the cycle if a cycle is present. (You do not know the length of the list in advance.)

public class Solution {

    public ListNode has_cycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( slow != null && slow.next != null 
                && fast != null && fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast ) {
                slow = head;
                while( slow != fast ) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
