
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)   return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf("#," + root.val));

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                sb.append("," + node.left.val);
            } else {
                sb.append(",#");
            }

            if (node.right != null) {
                queue.add(node.right);
                sb.append(","+node.right.val);
            } else {
                sb.append(",#");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int idx = 2;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!nodes[idx].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.add(node.left);
            }
            idx += 1;
            if (!nodes[idx].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.add(node.right);
            }
            idx += 1;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));