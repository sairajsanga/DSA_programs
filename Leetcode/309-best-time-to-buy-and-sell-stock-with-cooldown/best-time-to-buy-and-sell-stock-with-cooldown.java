class Solution {
    Integer dp[][];
    public int maxProfit(int[] nums) {
        int n=nums.length;
        this.dp=new Integer[nums.length+1][2];
        
        return solve(nums,0,0);
    }

    public int solve(int nums[],int idx,int state){

        if(idx>=nums.length) return 0;
        if(dp[idx][state]!=null) return dp[idx][state];

        int stock=nums[idx];
        int maxProfit=0;

        if(state==0){
            int buy=solve(nums,idx+1,1)-stock;
            int skip=solve(nums,idx+1,0);
            maxProfit=Math.max(buy,skip);
        }
        else{
            int sell=solve(nums,idx+2,0)+nums[idx];
            int notsell=solve(nums,idx+1,1);
            maxProfit=Math.max(sell,notsell);
        }

        return dp[idx][state]=maxProfit;
    }
}