class Solution {
    int dp[];
    boolean preCompute[][];
    public int maxPalindromes(String s, int k) {

        int n=s.length();
        this.dp=new int[n+1];
        Arrays.fill(dp,-1);
        this.preCompute = new boolean[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && (len <= 2 || preCompute[i + 1][j - 1])) {
                    preCompute[i][j] = true;
                }
            }
        }

       return solve(s,k,0);
    }

    public int solve(String s,int k,int idx){

        if(idx==s.length()) return 0;

        if(dp[idx]!=-1) return dp[idx];
        
        int ans=Integer.MIN_VALUE;
        for(int j=idx+k-1;j<s.length();j++){
            if(preCompute[idx][j]){
                int temp=1+solve(s,k,j+1);
                ans=Math.max(ans,temp);
            }
        }

        int skip=solve(s,k,idx+1);

        ans=Math.max(ans,skip);

        return dp[idx]=ans;
    }
}