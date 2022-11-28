package Ch02_Linked_Lists;

import CtCILibrary.LinkedListNode;

import java.util.HashMap;

public class Q01_RemoveDups {
    public static void deleteDups(LinkedListNode head){
        HashMap<Integer, Boolean> values = new HashMap<>();

        LinkedListNode cur = head.next;
        LinkedListNode prev = head;

        values.put(head.data, true);

        while (cur != null){
            if (values.containsKey(cur.data)){
                prev.next = cur.next;
                cur = cur.next;
            } else {
                values.put(cur.data, true);
                prev = cur;
                cur = cur.next;
            }


        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 5, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }

}
