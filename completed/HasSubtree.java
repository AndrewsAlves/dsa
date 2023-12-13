package completed;
public class HasSubtree {

    TreeNode mainTree;
    TreeNode subTree;

    public static void main(String[] args) {

        // test [1,1] [1]
        int[] treeArr = {3,4,5,1,-1,2};
        int[] subTreeArr = {3,1,2};

        HasSubtree it = new HasSubtree();
        it.mainTree = Utilities.insertLevelOrder(treeArr, 0);
        it.subTree = Utilities.insertLevelOrder(subTreeArr, 0);

        Utilities.inOrder(it.mainTree);
        Utilities.inOrder(it.subTree);

        System.out.println(it.isSubtree(it.mainTree, it.subTree));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == subRoot) return true;

        if (root != null && subRoot != null) {
            boolean sameLeft, sameRight;
            if (root.val == subRoot.val) {

                sameLeft = isSubtree(root.left, subRoot.left);
                sameRight = isSubtree(root.right, subRoot.right);
                if (sameLeft && sameRight) {
                    return true;
                } else {  
                    sameLeft = isSubtree(root.left, subRoot);
                    sameRight = isSubtree(root.right, subRoot);
                    if (sameLeft || sameRight) {
                        return true;
                    } else {
                        return false;
                    }
                }

            } else {
                sameLeft = isSubtree(root.left, subRoot);
                sameRight = isSubtree(root.right, subRoot);
                if (sameLeft || sameRight) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
