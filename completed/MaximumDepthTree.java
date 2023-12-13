package completed;
public class MaximumDepthTree {

    TreeNode root;

    public static void main(String[] args) {
        int[] vals = {5,7,20,9,31,42,26,36};

        MaximumDepthTree it = new MaximumDepthTree();
        it.root = Utilities.insertLevelOrder(vals, 0);
        Utilities.inOrder(it.root);
        int max = it.maximumDepth(it.root,0);
        System.out.println(max);
    }

    public int maximumDepth(TreeNode root, int max) {
        int leftMax, rightMax;
        if (root != null) {
            max++;
            leftMax = maximumDepth(root.left, max);
            rightMax = maximumDepth(root.right, max);
            if (leftMax > rightMax) max = leftMax;
            else rightMax = max;
        }
        return max;
    }
}

