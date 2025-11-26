class Solution {
    public int jump(int[] nums) {
       int n=nums.length;
       int dp[]=new int[n];
       Arrays.fill(dp,-1);
       return solve(nums,n,0,dp);
    }

    public int solve(int nums[],int n,int start,int dp[]){
        if(start>=n-1) return 0;
        if(dp[start]!=-1) return dp[start];
        int ele=nums[start];
        int min=nums.length;
        for(int i=start+1;i<=start+ele;i++){
           min=Math.min(1+solve(nums,n,i,dp),min);
        } 
        return dp[start]=min;
    }
}