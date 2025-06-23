
 public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

class Solution {

    int maxlong = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.maxlong;
    }

    public int dfs(TreeNode node) {

        if (node == null) return -1;

        int left = dfs(node.left);
        int right = dfs(node.right);

        this.maxlong = Math.max(this.maxlong, left + right + 2);
        return Math.max(left, right) + 1;
    }
}