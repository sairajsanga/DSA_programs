import java.util.*;

class Solution {

    static int[][] dp;
    static int INF = 1000000000;

    public int minOperations(int[] nums, int sum) {

        dp = new int[nums.length][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(nums, 0, sum);

        return ans == INF ? -1 : ans;
    }

    static int solve(int[] nums, int idx, int sum) {

        if (sum == 0) {
            return 0;
        }

        if (idx == nums.length) {
            return INF;
        }

        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }

        // Don't take current number
        int ans = solve(nums, idx + 1, sum);

        int num = nums[idx];

        // -------------------------
        // Multiplication
        // -------------------------

        int value = num;
        int cost = 0;

        while (value <= sum) {

            int remaining = sum - value;

            int next = solve(nums, idx + 1, remaining);

            if (next != INF) {
                ans = Math.min(ans, cost + next);
            }

            value *= 2;
            cost++;
        }

        // -------------------------
        // Division
        // -------------------------

        value = num;
        cost = 0;

        while (value > 0) {

            // Divide FIRST
            value /= 2;
            cost++;

            if (value == 0) {
                break;
            }

            if (value <= sum) {

                int remaining = sum - value;

                int next = solve(nums, idx + 1, remaining);

                if (next != INF) {
                    ans = Math.min(ans, cost + next);
                }
            }
        }

        return dp[idx][sum] = ans;
    }
}