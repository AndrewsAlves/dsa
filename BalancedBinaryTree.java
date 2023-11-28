

public class BalancedBinaryTree {

    public TreeNode root;

    public static void main(String[] args) {
        // 1,2,2,3,3,-1,-1,4,4
        // 3,9,20,-1,-1,15,7
        // 3
        int[] vals = {3,9,20,-1,-1,15,7};

        BalancedBinaryTree it = new BalancedBinaryTree();
        it.root = Utilities.insertLevelOrder(vals, 0);
        Utilities.inOrder(it.root);

        System.out.println(it.isBalanced(it.root, 0));
    }
 
    public int isBalanced(TreeNode root, int height) {
        if (root != null) {
            int leftHeight;
            int rightHeight;
            height++;
            leftHeight = isBalanced(root.left, height);
            rightHeight = isBalanced(root.right, height);
            if (leftHeight == -1 || rightHeight == -1) {
                return -1;
            }
            if (Math.abs(leftHeight - rightHeight) > 1) {
                System.out.println("\n Unbalanced");
                return -1;
            }
            return Math.max(leftHeight, rightHeight);
        }
        return height;
    }
}
