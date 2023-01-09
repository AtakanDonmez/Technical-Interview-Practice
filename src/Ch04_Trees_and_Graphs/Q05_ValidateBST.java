package Ch04_Trees_and_Graphs;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class Q05_ValidateBST {
    public static boolean checkBST(TreeNode n) {
        return (checkBST(n.left, Integer.MIN_VALUE, n.data) &&
                checkBST(n.right, n.data, Integer.MAX_VALUE));
    }

    public static boolean checkBST(TreeNode n, int min, int max) {
        if (n == null) return true;

        if (checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max)){
            return (n.data >= min && n.data <= max);
        } else {
            return false;
        }
    }

    /* Create a tree that may or may not be a BST */
    public static TreeNode createTestTree() {
        /* Create a random BST */
        TreeNode head = AssortedMethods.randomBST(10, -10, 10);

        /* Insert an element into the BST and potentially ruin the BST property */
        TreeNode node = head;
        do {
            int n = AssortedMethods.randomIntInRange(-10, 10);
            int rand = AssortedMethods.randomIntInRange(0, 5);
            if (rand == 0) {
                node.data = n;
            } else if (rand == 1) {
                node = node.left;
            } else if (rand == 2) {
                node = node.right;
            } else if (rand == 3 || rand == 4) {
                break;
            }
        } while (node != null);

        return head;
    }

    public static void main(String[] args) {
        /* Simple test -- create one */
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 6; // "ruin" the BST property by changing one of the elements
        node.print();
        boolean isBst = checkBST(node);
        System.out.println(isBst);
    }
}
