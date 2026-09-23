class Solution {
    Integer dp[][];
    public int coinChange(int[] coins, int target) {
        this.dp=new Integer[target+1][coins.length+1];
        int ans=solve(coins,target,0);
        return ans==Integer.MAX_VALUE/2?-1:ans;
    }
    public int solve(int nums[],int target,int idx){
     
     if(target==0) return 0;
  
     if(idx>=nums.length||target<0){
         return Integer.MAX_VALUE/2;
     }
     
     if(dp[target][idx]!=null) return dp[target][idx];
    
     int take=1+solve(nums,target-nums[idx],idx);
     int nottake=solve(nums,target,idx+1);

     return dp[target][idx]=Math.min(take,nottake);
}
}