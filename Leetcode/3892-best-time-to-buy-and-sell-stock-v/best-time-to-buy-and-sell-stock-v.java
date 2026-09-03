class Solution {

    Long[][][] dp;

    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;

        dp = new Long[n][k + 1][3];

        return solve(prices, 0, k, 0);
    }

    private long solve(int[] prices, int idx, int k, int state) {

        if (idx == prices.length) {
            return state == 0 ? 0 : Long.MIN_VALUE / 4;
        }

        if (dp[idx][k][state] != null) {
            return dp[idx][k][state];
        }

        long ans;

        // ---------------------------------
        // STATE 0 : No open transaction
        // ---------------------------------
        if (state == 0) {

            // Do nothing
            ans = solve(prices, idx + 1, k, 0);

            if (k > 0) {

                // Open LONG:
                // Buy today
                long buy = -prices[idx]
                        + solve(prices, idx + 1, k - 1, 1);

                // Open SHORT:
                // Sell today
                long shortSell = prices[idx]
                        + solve(prices, idx + 1, k - 1, 2);

                ans = Math.max(ans, Math.max(buy, shortSell));
            }
        }

        // ---------------------------------
        // STATE 1 : Holding LONG
        // ---------------------------------
        else if (state == 1) {

            // Keep holding
            long hold = solve(prices, idx + 1, k, 1);

            // Sell today and close transaction
            long sell = prices[idx]
                    + solve(prices, idx + 1, k, 0);

            ans = Math.max(hold, sell);
        }

        // ---------------------------------
        // STATE 2 : Holding SHORT
        // ---------------------------------
        else {

            // Keep holding short
            long hold = solve(prices, idx + 1, k, 2);

            // Buy back today and close transaction
            long buyBack = -prices[idx]
                    + solve(prices, idx + 1, k, 0);

            ans = Math.max(hold, buyBack);
        }

        return dp[idx][k][state] = ans;
    }
}