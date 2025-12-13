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

        q.offer(root);
        int d = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            if (d == depth - 1) {
                for (int i = 0; i < q.size(); i++) {

                    TreeNode fakeroot = q.poll();
                    TreeNode leftTemp = fakeroot.left;
                    TreeNode rightTemp = fakeroot.right;

                    fakeroot.left = new TreeNode(val);
                    fakeroot.right = new TreeNode(val);

                    fakeroot.left.left = leftTemp;
                    fakeroot.right.right = rightTemp;

                }
            }
            else{
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            d++;
            }

        }
        return root;
    }
}