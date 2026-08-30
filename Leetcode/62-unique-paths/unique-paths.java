class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return paths(m,n,0,0,dp);
    }
    int paths(int m,int n,int r,int c,int dp[][]){
        if(r==m-1||c==n-1) return 1;
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int down=paths(m,n,r+1,c,dp);
        int right=paths(m,n,r,c+1,dp);
        return dp[r][c]=down+right;
    }
}