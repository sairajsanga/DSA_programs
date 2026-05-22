class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;

        this.dp=new int[n+1];
        Arrays.fill(dp,-1);

       return helper(nums,0);
    }

    public int helper(int nums[],int start){
        int n=nums.length;
        if(start>=n) return 0;

        if(dp[start]!=-1) return dp[start];

        int rob=nums[start]+helper(nums,start+2);

        int notrob=helper(nums,start+1);

        return dp[start]=Math.max(rob,notrob);
    }
}