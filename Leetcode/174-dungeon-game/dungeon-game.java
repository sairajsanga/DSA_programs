class Solution {
    int dp[][];
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        this.dp=new int[m][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(dungeon,0,0);
    }

    public int helper(int [][] dungeon,int row,int col){
        int m=dungeon.length;
        int n=dungeon[0].length;

        if(row>=m||col>=n) return Integer.MAX_VALUE;
        
   

        if (row == m - 1 && col == n - 1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }

        if(dp[row][col]!=-1) return dp[row][col];

        

        
        int right=helper(dungeon,row,col+1);

        int down=helper(dungeon,row+1,col);

        
         
        int nexthealth= Math.min(right,down)-dungeon[row][col];  
       return dp[row][col] = Math.max(1, nexthealth);
    }
}