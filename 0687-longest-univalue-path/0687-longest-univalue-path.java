
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

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.left.val == node.val)
            left += 1;
        else
            left = 0;
        if (node.right != null && node.right.val == node.val)
            right += 1;
        else
            right = 0;

        this.res = Math.max(this.res, left + right);
        return Math.max(left, right);
    }
}