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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;

        if (depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int levelsize = q.size();

            if (level == depth - 1) {
                for (int i = 0; i < levelsize; i++) {
                    TreeNode curr = q.poll();

                    TreeNode lefttemp = curr.left;
                    TreeNode righttemp = curr.right;

                    curr.left = new TreeNode(val);
                    curr.right = new TreeNode(val);
                    curr.left.left = lefttemp;
                    curr.right.right = righttemp;
                }
                break;
            }

            for (int i = 0; i < levelsize; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            level++;
        }
        return root;

    }
}