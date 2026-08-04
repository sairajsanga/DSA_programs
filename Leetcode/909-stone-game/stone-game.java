class Solution {
    int dp[][];
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        this.dp=new int[n][n];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return solve(piles,0,n-1)>=0;
    }

    public int solve(int nums[],int i, int j){
        if(i>j) return 0;

        if(i==j) return nums[i]; 

        if(dp[i][j]!=-1) return dp[i][j];

        int left=nums[i]-solve(nums,i+1,j);
        int right=nums[j]-solve(nums,i,j-1);

        return dp[i][j]=Math.max(left,right);
    }
}