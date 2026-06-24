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
    public int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        preorder(root, root.val);
        return count;
    }

    public void preorder(TreeNode node, int maxVal) {
        if(node.val >= maxVal) count ++;
        int currMaxVal = Math.max(maxVal, node.val);
        if (node.left != null) preorder(node.left, currMaxVal);
        if (node.right != null) preorder(node.right, currMaxVal);
    }
}
