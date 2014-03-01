// Problem 7.12
// Implement a function which takes as input a pointer to the head of a
// postings list L, and returns a copy of the postings list. Your function should
// take O(n) time, where n is the length of the postings list and should use O(1)
// storage beyond that required for the n nodes in the copy. You can modify the
// original list, but must restore it to its initial state before returning.

public class problem_07_12 {

    public PListNode copy_postings_list(PListNode head) {
        if( head == null ) 
            return null;

        // step 1. copy the postings list
        PListNode cur = head;
        while( cur != null ) {
            PListNode newNode = new PListNode(cur.data);
            PListNode next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }

        // step 2. update jump of the copied list
        cur = head;
        while( cur != null ) {
            if( cur.jump != null ) {
                cur.next.jump = cur.jump.next;
            }
            cur = cur.next.next;
        }

        // step 3. split the lists
        cur = head;
        PListNode copied = cur.next;
        while( cur.next != null ) {
            PListNode tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return copied;

    }

    public static void main(String[] argv) {
        // unit test
        problem_07_12 solutions = new problem_07_12();

        // list1:   1 -> 2 -> 3 -> 2 -> 1 -> null
        PListNode n1 = new PListNode(1);
        PListNode n2 = new PListNode(2);
        n1.next = n2;
        PListNode n3 = new PListNode(3);
        n2.next = n3;
        PListNode n4 = new PListNode(4);
        n3.next = n4;
        PListNode n5 = new PListNode(5);
        n4.next = n5;

        PListNode copied = solutions.copy_postings_list(n1);
        PListNode cur = copied;
        while( cur != null ) {
            System.out.print( cur.data + " => ");
            cur = cur.next;
        }
        System.out.print( "null\n");


    }
}

class PListNode {
    public int data;
    public PListNode next;
    public PListNode jump;
    public PListNode(int v) { data = v; jump = null; next = null; }
}
