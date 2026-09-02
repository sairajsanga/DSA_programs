class Solution {

    Boolean dp[][];

    public boolean canCross(int[] stones) {

        int n = stones.length;

        // First jump must be exactly 1
        if (n > 1 && stones[1] != 1) {
            return false;
        }

        dp = new Boolean[n][n + 1];

        return solve(stones, 1, 1);
    }

    public boolean solve(int[] stones, int idx, int k) {

        if (idx == stones.length - 1) {
            return true;
        }

        if (dp[idx][k] != null) {
            return dp[idx][k];
        }

        boolean ans = false;

        // Try k - 1, k, k + 1
        for (int jump = k - 1; jump <= k + 1; jump++) {

            if (jump <= 0) {
                continue;
            }

            int nextPosition = stones[idx] + jump;

            int nextIdx = Arrays.binarySearch(stones, nextPosition);

            if (nextIdx >= 0) {

                if (solve(stones, nextIdx, jump)) {
                    ans = true;
                    break;
                }
            }
        }

        return dp[idx][k] = ans;
    }
}