
import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        int[] vals = {5,7,20,9,31,42,26};
        
        TreeNode root = null;
        root = TreeNode.insertLevelOrder(vals, 0);
        TreeNode.inOrder(root);
        List<List<Integer>> levelNodesList = new ArrayList<>();
        getTreeAsLevels(root, 0, levelNodesList);
    }

    public static void getTreeAsLevels(TreeNode node, int level, List<List<Integer>> levelNodesList) {

        if (node == null) return;
        
        if (levelNodesList.size() >= level+1) {
            levelNodesList.get(level).add(node.val);
        } else {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.val);
            levelNodesList.add(levelList);
        }

        getTreeAsLevels(node.left, level+1, levelNodesList);
        getTreeAsLevels(node.right, level+1, levelNodesList);
    }
}
