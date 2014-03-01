// Problem 7.10
// Write a function that determines whether a sequence represented by
// a singly linked list L is a palindrome. Assume L can be changed and
// does not have to be restored it to its original state.

public class problem_07_10 {

    public boolean is_linked_list_a_palindrome(ListNode head) {
        if( head == null || head.next == null ) 
            return true;

        // step 1. find the middle point
        ListNode fast = head;
        ListNode slow = head;
        while( fast != null ) {
            fast = fast.next;
            if( fast != null ) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        // step 2. compare the first half and reversed second half
        ListNode reverse = reverse_linked_list(slow.next);
        while( reverse != null && head != null ) {
            if( reverse.data != head.data )
                return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse_linked_list(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while( cur != null ) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] argv) {
        // unit test
        problem_07_10 solutions = new problem_07_10();

        // list1:   1 -> 2 -> 3 -> 2 -> 1 -> null
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(1);
        n4.next = n5;

        boolean ans = solutions.is_linked_list_a_palindrome(n1);
        System.out.println(ans);
    }
}

class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int v) { data = v; next = null; }
}
