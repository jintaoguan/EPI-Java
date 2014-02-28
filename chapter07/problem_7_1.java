// Problem 7.1
// Write a function that takes L and F, and returns the merge of L 
// and F. Your code should use O(1) additional storage - it should reuse the nodes from 
// the lists provided as input. The only field you can change in a node is next.

public class problem_7_1 {

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

    public static void main(String[] argv) {
        
        // unit test
        problem_7_1 solutions = new problem_7_1();

        // list1:   1 -> 3 -> 5 -> 7 -> 9
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(5);
        n2.next = n3;
        ListNode n4 = new ListNode(7);
        n3.next = n4;
        ListNode n5 = new ListNode(9);
        n4.next = n5;

        // list2:  4 -> 6 -> 8 -> 10
        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(6);
        m1.next = m2;
        ListNode m3 = new ListNode(8);
        m2.next = m3;
        ListNode m4 = new ListNode(10);
        m3.next = m4;

        ListNode newhead = solutions.merge_sorted_linked_lists(n1,m1);
        while( newhead != null ) {
            System.out.print( newhead.data + " => ");
            newhead = newhead.next;
        }
        System.out.print( "null");
    }
}

class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int v) { data = v; next = null; }
}
