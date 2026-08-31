class Solution {
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        this.n=coins.length;
        this.dp=new int[amount+1][n+1];
        for(int num[]:dp){
           Arrays.fill(num,-1);
        }
        return helper(coins,amount,0);
    }

    public int helper(int coins[],int amount,int start){
        if(start>=n||amount<0) return 0;

        if(amount==0) return 1;

        if(dp[amount][start]!=-1) return dp[amount][start];

        int val=coins[start];

        int take=helper(coins,amount-val,start);

        int skip=helper(coins,amount,start+1);

        return dp[amount][start]=take+skip;
    }
}