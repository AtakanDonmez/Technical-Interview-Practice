package Ch02_Linked_Lists;

import CtCILibrary.LinkedListNode;

public class Q04_Partition {
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head1, head2, cur, last1, last2;
        cur = node;
        head1 = null;
        head2 = null;
        last1 = null;
        last2 = null;
        while (cur != null){
            if (cur.data < x){
                if (last1 == null){
                    head1 = new LinkedListNode(cur.data);
                    last1 = head1;
                } else {
                    LinkedListNode newNode = new LinkedListNode(cur.data, null, last1);
                    last1.next = newNode;
                    last1 = last1.next;
                }
            } else {
                if (last2 == null){
                    head2 = new LinkedListNode(cur.data);
                    last2 = head2;
                } else {
                    LinkedListNode newNode = new LinkedListNode(cur.data, null, last2);
                    last2.next = newNode;
                    last2 = last2.next;
                }
            }

            cur = cur.next;
        }

        last1.next = head2;
        if (head2 != null){
            head2.prev = last1;
        }

        return head1;
    }

    public static void main(String[] args) {
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());

        LinkedListNode h = partition(head, 8);
        System.out.println(h.printForward());
    }
}
