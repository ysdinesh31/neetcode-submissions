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
    public boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        postorder(root);
        return ans;
    }
    public int postorder(TreeNode node) {
        if (node == null) return 0;
        int left = postorder(node.left);
        int right = postorder(node.right);
        ans = ans && Math.abs(left - right) <= 1;
        return 1 + Math.max(left, right);
    }
}
