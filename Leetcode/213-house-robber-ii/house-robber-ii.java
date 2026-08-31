class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        if( n == 1 ) return nums[0];
        this.dp=new int [n+1];
        Arrays.fill(dp,-1);
       int first=helper(nums,0,n-1);

        Arrays.fill(dp,-1);
       int secound=helper(nums,1,n);
       return Math.max(first,secound);
    }

     public int helper(int nums[],int start,int n){
        
        if(start>=n) return 0;
        

        if(dp[start]!=-1) return dp[start];

        int rob=nums[start]+helper(nums,start+2,n);

        int notrob=helper(nums,start+1,n);

        return dp[start]=Math.max(rob,notrob);
    }
}