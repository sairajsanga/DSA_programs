class Solution {
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;
        int dp[][]=new int[5001][2];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        boolean buy=true;
        return solve(prices,0,n,buy,dp);
    }
    public int solve(int prices[],int index,int n,boolean buy,int dp[][]){
        if(index>=prices.length){
            return 0;
        }
        if(dp[index][buy?1:0]!=-1){
            return dp[index][buy?1:0];
        }
        int profit=0;
        if(buy){
            int take=solve(prices,index+1,n,false,dp)-prices[index];
            int notake=solve(prices,index+1,n,true,dp);
            profit=Math.max(take,notake);
        }
        else{
            int sell=prices[index]+solve(prices,index+2,n,true,dp);
            int nosell=solve(prices,index+1,n,false,dp);
             profit=Math.max(sell,nosell);
        }
        return dp[index][buy?1:0]=profit;
    }
}