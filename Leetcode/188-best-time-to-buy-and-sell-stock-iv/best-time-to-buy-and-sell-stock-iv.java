class Solution {
    Integer dp[][];
    public int maxProfit(int k, int[] nums) {
        int n=nums.length;
        this.dp=new Integer[n+1][k+1];
        int res=solve(nums,0,k);
        return res;
    }

    public int solve(int nums[],int idx,int limit){

        if(idx>=nums.length||limit==0) return 0;

        if(dp[idx][limit]!=null) return dp[idx][limit];
    
        int stock=nums[idx];
        int maxProfit=0;
        for(int i=idx+1;i<nums.length;i++){
           int profit=nums[i]-stock;
           if(profit<=0) continue;

           int take=solve(nums,i+1,limit-1);
           maxProfit=Math.max(maxProfit,take+profit);
        }

        int skip=solve(nums,idx+1,limit);
        return dp[idx][limit]=Math.max(maxProfit,skip);
    }

}