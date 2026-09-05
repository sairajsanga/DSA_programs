class Solution {
    Boolean dp[];
    public boolean winnerSquareGame(int n) {
        this.dp=new Boolean[n+1];
        return solve(n)?true:false;
    }

    public boolean solve(int n){

        if(n==0) return false;
        if(dp[n]!=null) return dp[n];

        for(int k=1;k*k<=n;k++){
            if(!solve(n-k*k)) return dp[n]=true;
        }

        return dp[n]=false;
    }

}