class Solution {
    int dp[][];
    public int coinChange(int[] coins, int sum) {
       int n=coins.length;
       this.dp=new int[sum+1][n+1];
       for(int arr[]:dp) Arrays.fill(arr,-1);
       return helper(coins,sum,0)==Integer.MAX_VALUE-1?-1:helper(coins,sum,0);
    }

    public int helper(int nums[],int sum,int start){

        if(start>=nums.length||sum<0) return Integer.MAX_VALUE-1;
        
        if(sum==0) return 0;

        if(dp[sum][start]!=-1) return dp[sum][start];
        

        int value=nums[start];

        int take=1+helper(nums,sum-value,start);

        int skip=helper(nums,sum,start+1);

        
        return dp[sum][start]=Math.min(take,skip);
    }
    
}


