class Solution {
    int dp[]=new int[102];
    public int rob(int[] nums) {  
        int n=nums.length;
        int dp[]=new int[nums.length+1];
        if(n==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]); 
        }
        return dp[n-1];
    }
    // public int helper(int nums[],int i,int n){
    //     if(i>=n){
    //         return 0;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     return dp[i]=Math.max(helper(nums,i+2,n)+nums[i],helper(nums,i+1,n));
    // }
}