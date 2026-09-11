class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return 0;

        return solve(root, targetSum)
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }

    public int solve(TreeNode root, long target) {

        if (root == null)
            return 0;

        int count = 0;

        if (root.val == target)
            count++;

        count += solve(root.left, target - root.val);
        count += solve(root.right, target - root.val);

        return count;
    }
}