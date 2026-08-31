package RandomQues;


import java.util.*;

public class minimizingCoins {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);

        dp[0]=0;

        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        System.out.println(dp[x] < Integer.MAX_VALUE-1 ?dp[x]:-1);
    }

//    public static long solve(int[] coins, int x,long dp[]) {
//
//        // Base case
//        if (x == 0) {
//            return 0;
//        }
//
//        // Impossible
//        if (x < 0) {
//            return Long.MAX_VALUE;
//        }
//
//        // Already calculated
//        if (dp[x] != -1) {
//            return dp[x];
//        }
//
//        long min = Long.MAX_VALUE;
//
//        for (int coin : coins) {
//
//            long result = solve(coins, x - coin,dp);
//
//            if (result != Long.MAX_VALUE) {
//                min = Math.min(min, result + 1);
//            }
//        }
//
//        return dp[x] = min;
//    }
}