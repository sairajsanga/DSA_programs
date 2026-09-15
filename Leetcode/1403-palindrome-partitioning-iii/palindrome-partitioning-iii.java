class Solution {
    int preCompute[][];
    Integer dp[][];
    public int palindromePartition(String s, int k) {
        int n=s.length();
        this.preCompute = new int[n + 1][n + 1];
        this.dp=new Integer[n+1][k+1];
        

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)){
                    if(len>2&& preCompute[i+1][j-1]!=0){
                        preCompute[i][j]=preCompute[i+1][j-1];
                    }
                    
                } 
                else{
                        preCompute[i][j]=1+preCompute[i+1][j-1];
                }
            }
        }

        return solve(s,k,0);
    }

    public int solve(String s,int limit,int idx){
        if(idx==s.length()) return limit==0?0:Integer.MAX_VALUE/2;
        if(limit==0) return Integer.MAX_VALUE/2;

        if(dp[idx][limit]!=null) return dp[idx][limit];

        int ans=Integer.MAX_VALUE;

        for(int k=idx;k<s.length();k++){
            int change=preCompute[idx][k]+solve(s,limit-1,k+1);
            ans= Math.min(ans,change);
        }

        return dp[idx][limit]=ans;
    }
}