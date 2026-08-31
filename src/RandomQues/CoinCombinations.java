package RandomQues;

import java.util.*;

public class CoinCombinations {

    static long[] dp;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dp = new long[x + 1];


        System.out.println(solve(coins, x));
    }

    public static long solve(int[] coins, int x) {

//        if (x == 0) {
//            return 1;
//        }

        dp[0]=1;

        for(int i=1 ; i<=x ; i++) {
            for(int j = 0; j < coins.length; j++) {
                if (coins[j] <=i) {
                    dp[i] += dp[i - coins[j]];
                    dp[i] %= MOD;
                }
            }
        }

        return dp[x];
    }
}