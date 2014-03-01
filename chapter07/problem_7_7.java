// Problem 7.7
// Let v be a node in a singly linked list L. 
// Node v is not the tail; delete it in O(1) time.

public class problem_7_7 {

    public void deletion_from_list(ListNode v) {
        v.data = v.next.data;
        v.next = v.next.next;
    }

    public static void main(String[] argv) {
        // unit test
        problem_7_7 solutions = new problem_7_7();

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

        solutions.deletion_from_list(n5);
        ListNode newhead = n1;
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
