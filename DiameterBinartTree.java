public class DiameterBinartTree {
    TreeNode root;

    public static void main(String[] args) {
        int[] vals = {5,7,20,9,31,42,26,36};

        DiameterBinartTree it = new DiameterBinartTree();
        it.root = Utilities.insertLevelOrder(vals, 0);
        Utilities.inOrder(it.root);
        int[] diameter = new int[1];
        int max = it.maximumDepth(it.root,0, diameter);
        System.out.println(max);
    }

    public int maximumDepth(TreeNode root, int max, int[] diameter) {
        int leftMax, rightMax, leftEd, rightEd;
        if (root != null) {
            max++;
            leftMax = maximumDepth(root.left, max, diameter);
            rightMax = maximumDepth(root.right, max, diameter);
            leftEd = leftMax - max;
            rightEd = rightMax - max;
            diameter[0] = Math.max(diameter[0], leftEd + rightEd);
            if (leftMax > rightMax) max = leftMax;
            else max = rightMax;
        }
        return max;
    }
}
