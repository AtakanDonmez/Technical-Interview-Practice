package Ch02_Linked_Lists;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Q02_ReturnKthLast {
    public static LinkedListNode nthToLast(LinkedListNode head, int k) {
        if(k < 0) return null;

        LinkedListNode lagging = head;
        LinkedListNode cur = head;
        for (int i = 0; i < k; i++){
            if (cur == null) return null;
            cur = cur.next;
        }

        while (cur != null) {
            lagging = lagging.next;
            cur = cur.next;
        }

        return lagging;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            LinkedListNode node = nthToLast(head, i);
            String nodeValue = node == null ? "null" : "" + node.data;
            System.out.println(i + ": " + nodeValue);
        }
    }
}
