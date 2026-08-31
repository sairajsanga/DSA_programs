class Solution {
    Integer dp[];
    public int climbStairs(int n) {
        this.dp=new Integer[n+1];
        return solve(0,n);
    }

    public int solve(int idx,int n){

        if(idx==n) return 1;

        if(idx>n) return 0;

        if(dp[idx]!=null) return dp[idx];

        int first=solve(idx+1,n);
        int secound=solve(idx+2,n);

        return dp[idx]=first+secound;
    }
}