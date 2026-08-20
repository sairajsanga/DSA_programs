class Solution {

    int[] prefix;
    Integer[] dp;

    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        prefix = new int[n];
        dp = new Integer[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        return solve(1, n);
    }

    private int solve(int i, int n) {

        if (i == n - 1) {
            return prefix[i];
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int choose = prefix[i] - solve(i + 1, n);

        return dp[i] = Math.max(choose, solve(i + 1, n));
    }
}