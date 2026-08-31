package RandomQues;

import java.util.Scanner;

public class CoinCombinations2 {

    static int dp[][];
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();

        int coins[]=new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        dp=new int[n+1][x+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

       for(int i=n-1;i>=0;i--){
           for(int j=1;j<=x;j++){
               int skip=dp[i+1][j];
               int pick=0;
               if(coins[i]<=j){
                   pick=dp[i][j-coins[i]];
               }
               dp[i][j] = (int) (((long) skip + pick) % MOD);
           }
       }

        System.out.println(dp[0][x]);


    }
//    public static int solve(int coins[],int idx,int x){
//
//        if(x==0) return 1;
//
//        if(x<0||idx>=coins.length) return 0;
//
//        if(dp[idx][x]!=null) return dp[idx][x];
//
//        int take=solve(coins,idx,x-coins[idx]);
//
//        int skip=solve(coins,idx+1,x);
//
//        return dp[idx][x]=(take+skip)%mod;
//
//    }
}
