// Problem 7.6
// Write a function that takes a singly linked list L, and reorders the
// elements of L so that the new list represents even-odd(L). Your function should use
// O(1) additional storage. The only field you can change in a node is next.

public class problem_07_06 {

    public ListNode even_odd_merge(ListNode head) {
        if( head == null ) return null;
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;
        ListNode cur = head;
        int count = 0;
        while( cur != null ) {
            if( count % 2 == 0 ) {
                evenTail.next = cur;
                evenTail = evenTail.next;
            } else {
                oddTail.next = cur;
                oddTail = oddTail.next;
            }
            count++;
            cur = cur.next;
        }
        oddTail.next = null;
        evenTail.next = oddDummy.next;
        return evenDummy.next;
    }

    public static void main(String[] argv) {
        // unit test
        
        problem_07_06 solutions = new problem_07_06();

        // list1:   1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode n3 = new ListNode(2);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        ListNode n5 = new ListNode(4);
        n4.next = n5;
        ListNode n6 = new ListNode(5);
        n5.next = n6;

        ListNode newhead = solutions.even_odd_merge(n1);
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
