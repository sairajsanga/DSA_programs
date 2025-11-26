class Solution {
    int MOD=1000000007;
    int dp[][][];
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        this.dp=new int[m][n][k];
        
        for(int[][] a : dp) {
            for(int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
       return solve(grid,0,0,0,k);
    }
    public int solve(int grid[][],int i,int j,int sum,int k){
        int m=grid.length;
        int n=grid[0].length;

        if(i==m-1&&j==n-1){
            if((sum+grid[m-1][n-1])%k==0){
                return 1;
            }
            return 0;
        }
        if(i>=m||j>=n) return 0;
        
        sum+=grid[i][j];
        if(dp[i][j][sum%k] != -1) {
            return dp[i][j][sum%k];
        }
        int right=solve(grid,i,j+1,sum%k,k);
        int down=solve(grid,i+1,j,sum%k,k);
        
        return dp[i][j][sum%k]=(right+down)%MOD;
    }
}