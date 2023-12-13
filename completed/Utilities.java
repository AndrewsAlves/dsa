package completed;
public class Utilities {

    public static TreeNode insertLevelOrder(int[] arr, int i)
    {
          TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            if (arr[i] == -1) {
                root = null;
                return root;
            }
            root = new TreeNode(arr[i]);
 
            // insert left child
            root.left = insertLevelOrder(arr, (2 * i) + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, (2 * i) + 2);
        }
        return root;
    }

    public static void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
         this.right = right;
    }
}

class ListNode {
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
