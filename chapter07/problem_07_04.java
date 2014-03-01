// Problem 7.4
// Let h1 and h2 be the heads of lists L1 and L2, respectively. Assume 
// that L1 and L2 are well-formed, that is each consists of a finite sequence of nodes. (In
// particular, neither list has a cucle.) How would you determine if there exists a node r
// reachable from both h1 and h2 by following the next fields? If such a node exists, find
// the node that appears earliest when traversing the lists. You are constrained to use
// no more than constant storage.

public class problem_07_04 {

    public ListNode overlapping_no_cycle_lists(ListNode L1, ListNode L2) {
        int len1 = countLength(L1);
        int len2 = countLength(L2);
        ListNode longList = null;
        ListNode shortList = null;
        if( len1 > len2 ) {
            longList = L1;
            shortList = L2;
        } else {
            longList = L2;
            shortList = L1;
        }
        int diff = Math.abs(len1 - len2);
        for( int i = 0; i < diff; ++i ) {
            longList = longList.next;
        }
        while( shortList != null && longList != null && longList != shortList ) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    public int countLength(ListNode head) {
        int len = 0;
        while( head != null ) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] argv) {
        // unit test
        
        problem_07_04 solutions = new problem_07_04();

        // list1:   1 -> 2 -> 3 -> 4 -> 5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;

        // list2:  5 -> 6 -> 7 -> 8
        ListNode m5 = new ListNode(5);
        ListNode m6 = new ListNode(6);
        m5.next = m6;
        ListNode m7 = new ListNode(7);
        m6.next = m7;
        ListNode m8 = new ListNode(8);
        m7.next = m8;

        m8.next = n2;
        System.out.println(solutions.overlapping_no_cycle_lists(n1,m5).data);

        m8.next = null;
        System.out.println(solutions.overlapping_no_cycle_lists(n1,m5));

        m8.next = n4;
        System.out.println(solutions.overlapping_no_cycle_lists(n1,m5).data);
    }
}

class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int v) { data = v; next = null; }
}
