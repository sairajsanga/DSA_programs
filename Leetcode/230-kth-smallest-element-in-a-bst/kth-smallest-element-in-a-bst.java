class Solution {
    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return ans;
    }

    public void solve(TreeNode root, int k) {

        if (root == null) return;

        solve(root.left, k);

        count++;

        if (count == k) {
            ans = root.val;
            return;
        }

        solve(root.right, k);
    }
}