/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int leftHeight = calculateLeftHeight(root);
        int rightHeight = calculateRightHeight(root);
        
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        
        int leftSubtreeNodesCount = countNodes(root.left);
        int rightSubtreeNodesCount = countNodes(root.right);
        
        return leftSubtreeNodesCount + rightSubtreeNodesCount + 1;
    }
    
    private int calculateLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return calculateLeftHeight(root.left) + 1;
    }
    
    private int calculateRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return calculateRightHeight(root.right) + 1;
    }
}
