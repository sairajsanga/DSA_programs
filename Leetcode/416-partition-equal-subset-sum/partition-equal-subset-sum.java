class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int ele:nums) total+=ele;
        if(total%2!=0) return false;
        total=total/2;

        this.dp=new Boolean [total+1][n+1];

      
       return helper(nums,total,0); 
    }

    public boolean  helper(int nums[],int total,int start){
       
           if(total==0) return true;

           if(start>=nums.length||total<0) return false;

           if(dp[total][start]!=null) return dp[total][start];

           boolean take=helper(nums,total-nums[start],start+1);

           boolean skip=helper(nums,total,start+1);

           return dp[total][start]=take||skip;
        
    }
}