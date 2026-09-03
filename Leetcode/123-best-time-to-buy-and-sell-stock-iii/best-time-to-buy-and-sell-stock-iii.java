class Solution {
    Integer dp[][][];
    public int maxProfit(int[] nums) {
        int n=nums.length;
        this.dp=new Integer[n+1][3][2];
        int res=solve(nums,0,2,0);
        return res;
    }
    public int solve(int nums[],int idx,int limit,int state){

        if(idx>=nums.length||limit==0) return 0;

        if(dp[idx][limit][state]!=null) return dp[idx][limit][state];

        int ans=0;
        // not holding
        if(state==0){

            int skip=solve(nums,idx+1,limit,0);

            int buy=solve(nums,idx+1,limit,1)-nums[idx];

            ans=Math.max(skip,buy);
        }
        //holding 
        else{ 

            int hold=solve(nums,idx+1,limit,1);

            int sell=nums[idx]+solve(nums,idx+1,limit-1,0);

            ans=Math.max(hold,sell);
        }

        return dp[idx][limit][state]=ans;
    
       
    }
}