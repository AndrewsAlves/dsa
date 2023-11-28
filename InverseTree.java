
public class InverseTree {

    TreeNode root;
    
    public static void main(String[] args) {
        int[] vals = {5,7,20,9,31,42,26};

        InverseTree it = new InverseTree();
        it.root = Utilities.insertLevelOrder(vals, 0);
        Utilities.inOrder(it.root);
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode mainroot = root;
        invertRoot(root);
        return mainroot;
    }

    public void invertRoot(TreeNode root) {
        if (root != null) {
            TreeNode temp = null;
            if (root.left != null) {
                temp = new TreeNode(root.left.val, root.left.left, root.left.right);
            }
            
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
    }

}
