import java.util.Arrays;

import Utils.*;
public class PreOrderInOrderBT {
    public static void main(String[] args) {
        int[] preOrder = {-1};
        int[] inOrder = {-1};
        int[] index = {0};
        TreeNode head = generateTree(preOrder, inOrder, index);
        TreeNode.inOrder(head);
    }

    public static TreeNode generateTree(int[] preOrder, int[] subOrder, int[] index) {

        TreeNode node = null;
        int i = linearSearch(subOrder, preOrder[index[0]]);

        if (i == -1) return node;
        node = new TreeNode(preOrder[index[0]]);

        int[] left = Arrays.copyOfRange(subOrder, 0, i);
        int[] right = Arrays.copyOfRange(subOrder, i+1, subOrder.length);
        index[0]++;

        if (left.length != 0) {
            TreeNode leftNode = generateTree(preOrder, left, index);
            node.left = leftNode;
        }
        if (right.length != 0) {
            TreeNode rightNode = generateTree(preOrder, right, index);
            node.right = rightNode;
        }
        
        return node;
    }

    public static int linearSearch(int[] arr, int element) {
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }


}
