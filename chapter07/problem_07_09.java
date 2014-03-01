// Problem 7.9
// Given a linear time non-recursive function that reverses a singly linked
// list. The function should use no more than constant storage beyond that
// needed for the list itself.

public class problem_07_09 {

    // 1. recursive solution
    public ListNode reverse_linked_list_recursion(ListNode head) {
        if( head == null || head.next == null )
            return head;
        ListNode newhead = reverse_linked_list_recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    // 2. iterative solution
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
        problem_07_09 solutions = new problem_07_09();

        // list1:   1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(6);
        n5.next = n6;

        ListNode head1 = solutions.reverse_linked_list_recursion(n1);
        ListNode newhead = head1;
        while( newhead != null ) {
            System.out.print( newhead.data + " => ");
            newhead = newhead.next;
        }
        System.out.print( "null\n");

        ListNode head2 = solutions.reverse_linked_list(head1);
        newhead = head2;
        while( newhead != null ) {
            System.out.print( newhead.data + " => ");
            newhead = newhead.next;
        }
        System.out.print( "null\n");
        

    }
}

class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int v) { data = v; next = null; }
}
