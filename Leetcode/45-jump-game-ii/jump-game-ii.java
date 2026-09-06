class Solution {
    Integer dp[];
    public int jump(int[] nums) {
        int n = nums.length;
        this.dp=new Integer[n+1];
        return solve(nums, n, 0);
    }

    public int solve(int nums[], int n, int start) {
        if (start >= n - 1)
            return 0;
        if(dp[start]!=null) return dp[start];
        int ele = nums[start];
        int min = nums.length;

        for (int i = 1; i <= ele && start + i < n; i++) {
            min = Math.min(min, 1 + solve(nums, n, start + i));
        }
        return dp[start]=min;
    }
}