package Ch02_Linked_Lists;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Q03_DeleteMiddleNode {
    public static boolean deleteNode(LinkedListNode n) {
        if(n.prev == null || n.next == null){
            return false;
        }
        n.prev.next = n.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}
