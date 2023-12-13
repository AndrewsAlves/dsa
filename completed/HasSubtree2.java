package completed;
public class HasSubtree2 {

    TreeNode mainTree;
    TreeNode subTree;

    public static void main(String[] args) {

        // test [1,1] [1]
        int[] treeArr = {3,4,5,1,-1,2};
        int[] subTreeArr = {3,1,2};

        HasSubtree2 it = new HasSubtree2();
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
                if (!isSameTree(root, subRoot)) {
                    sameLeft = isSubtree(root.left, subRoot);
                    sameRight = isSubtree(root.right, subRoot);
                    if (sameLeft || sameRight) {
                        return true;
                    }
                } else {
                    return true;
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
        }

        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSameLeft, isSameRight;
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                isSameLeft = isSameTree(p.left, q.left);
                isSameRight = isSameTree(p.right, q.right);
                if (isSameLeft == isSameRight) {
                    return isSameLeft;
                } else {
                    return false;
                }
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }
}
