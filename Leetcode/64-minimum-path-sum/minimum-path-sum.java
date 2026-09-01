class Solution {
    int m;
    int n;
    int dp[][];
    public int minPathSum(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.dp=new int[m+1][n+1];
        for(int d[]:dp){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        return solve(grid,0,0);
    }

    public int solve(int grid[][],int startR,int startC){
        if(startR>=m||startC>=n) return Integer.MAX_VALUE;

        if(startR==m-1&&startC==n-1) return grid[startR][startC];

        if(dp[startR][startC]!=Integer.MAX_VALUE) return dp[startR][startC];
        
        int right=solve(grid,startR,startC+1);
        int down=solve(grid,startR+1,startC);

        return dp[startR][startC]=grid[startR][startC]+Math.min(right,down);
    }
}