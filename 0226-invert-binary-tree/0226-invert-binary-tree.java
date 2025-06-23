

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
    public TreeNode invertTree(TreeNode root) {
        root = dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        TreeNode tmp = new TreeNode(node.val);
        tmp = node.left;
        node.left = dfs(node.right);
        node.right = dfs(tmp);

        return node;
    }
}