class Solution {
    int dp[][]=new int[5001][2];
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        boolean buy=true;
        return solve(prices,0,n,buy);
    }
    public int solve(int prices[],int index,int n,boolean buy){
        if(index>=prices.length){
            return 0;
        }
        if(dp[index][buy?1:0]!=-1){
            return dp[index][buy?1:0];
        }
        int profit=0;
        if(buy){
            int take=solve(prices,index+1,n,false)-prices[index];
            int notake=solve(prices,index+1,n,true);
            profit=Math.max(take,notake);
        }
        else{
            int sell=prices[index]+solve(prices,index+2,n,true);
            int nosell=solve(prices,index+1,n,false);
             profit=Math.max(sell,nosell);
        }
        return dp[index][buy?1:0]=profit;
    }
}