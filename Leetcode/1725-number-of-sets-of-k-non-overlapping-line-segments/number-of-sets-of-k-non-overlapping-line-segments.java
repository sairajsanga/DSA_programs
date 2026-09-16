class Solution {
    int mod=1000000007;
    long dp[][];
    public int numberOfSets(int n, int k) {
        this.dp=new long[n+1][k+1];
        for(long d[]:dp) Arrays.fill(d,-1);
        return (int)solve(0,n,k);
    }

    public long solve(int idx,int n,int k){
        
        if(k==0){
            return 1;
        }

        if (idx >= n || n - idx < k + 1) {
            return 0;
        }

        if(dp[idx][k]!=-1) return dp[idx][k];

        long take=0;
        for(int j=idx+1;j<n;j++){
            take+=solve(j,n,k-1);
            take=take%mod;
        }

        long skip=solve(idx+1,n,k);
        skip=skip%mod;

        return dp[idx][k]=(take+skip)%mod;
    }

}