class Solution {
    int dp[]=new int[102];
    public int rob(int[] nums) {  
        Arrays.fill(dp,-1);
         return helper(nums,0,nums.length);
    }
    public int helper(int nums[],int i,int n){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=Math.max(helper(nums,i+2,n)+nums[i],helper(nums,i+1,n));
    }
}