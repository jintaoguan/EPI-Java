// Problem 7.8
// Given a singly linked list L and a number k, write a function to remove
// the k-th last element fron L. Your algorithm cannot use more than a few words of
// storage, regardless of the length of the list. In particular, you cannot assume that
// it is possible to record the legnth of the list.

public class problem_7_8 {

    public void remove_kth_last( ListNode L, int k ) {
        int num = k;
        ListNode ahead = L;
        while( ahead != null && num != 0 ) {
            num--;
            ahead = ahead.next;
        }

        // the linked list L is not long enough
        if( num > 0 ) return;

        ListNode pre = null;
        ListNode cur = L;
        while( ahead != null ) {
            pre = cur;
            cur = cur.next;
            ahead = ahead.next;
        }

        // there are 2 cases: 
        // 1. pre == null, the k-th element is the first element. 
        // 2. pre != null, the k-th node is not the first node.
        if( pre != null )
            pre.next = cur.next;
        else
            L = cur.next;
    }

    public static void main(String[] argv) {
        // unit test
        problem_7_8 solutions = new problem_7_8();

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

        solutions.remove_kth_last(n1, 2);
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
