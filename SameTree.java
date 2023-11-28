public class SameTree {
    TreeNode root,root2;
    public static void main(String[] args) {

        int[] vals = {3,9,20,36,27,15,7};
        int[] vals2 = {3,9,20,36,27,15};

        SameTree it = new SameTree();
        it.root = Utilities.insertLevelOrder(vals, 0);
        it.root2 = Utilities.insertLevelOrder(vals2, 0);

        System.out.println(it.isSameTree(it.root, it.root2));
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
