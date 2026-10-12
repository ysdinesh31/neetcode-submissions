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
    public int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    public void dfs(TreeNode node, int num) {
        if(node == null) return;
        if(node.val >= num) ans ++;
        // System.out.println(node.val + "," + num);
        dfs(node.left, Math.max(num, node.val));
        dfs(node.right, Math.max(num, node.val));
    }
}
