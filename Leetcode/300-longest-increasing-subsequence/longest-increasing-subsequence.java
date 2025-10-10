class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int [nums.length+1][nums.length+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
       return helper(nums,0,-1,dp);
    }
    public int helper(int []nums,int i,int p,int dp[][]){
        if(i>=nums.length){
         return 0;
        }

        if(p!=-1&&dp[i][p]!=-1){
            return dp[i][p];
        }

        int take=0;
        if(p==-1||nums[p]<nums[i]){
           take=1+helper(nums,i+1,i,dp); 
        }
       
        
        int skip=helper(nums,i+1,p,dp);
        if(p!=-1){
            dp[i][p]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}