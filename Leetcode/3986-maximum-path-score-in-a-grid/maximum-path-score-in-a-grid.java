class Solution {
    Integer[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        dp = new Integer[m][n][k + 1];
        return dfs(grid, 0, 0, k);
    }

    private int dfs(int[][] grid, int i, int j, int remainingCost) {
        int m = grid.length, n = grid[0].length;

        if (i >= m || j >= n) return -1;

        int cost = (grid[i][j] == 0) ? 0 : 1;
        int addScore = (grid[i][j] == 2) ? 2 : grid[i][j];

        remainingCost -= cost;
        if (remainingCost < 0) return -1;

        if (i == m - 1 && j == n - 1) return addScore;

        if (dp[i][j][remainingCost] != null) return dp[i][j][remainingCost];

        int right = dfs(grid, i, j + 1, remainingCost);
        int down = dfs(grid, i + 1, j, remainingCost);

        int bestNext = Math.max(right, down);
        dp[i][j][remainingCost] = (bestNext == -1) ? -1 : addScore + bestNext;

        return dp[i][j][remainingCost];
    }
}