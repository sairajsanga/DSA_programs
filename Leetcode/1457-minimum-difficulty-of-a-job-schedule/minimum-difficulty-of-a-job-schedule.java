class Solution {
    Integer dp[][];
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        this.dp=new Integer[d+1][n+1];
        if(n<d) return -1;
        return solve(jobDifficulty,d,0);
    }

    public int solve(int nums[],int d,int idx){

       if(d==1){
          int max=0;
          for(int i=idx;i<nums.length;i++){
            max=Math.max(max,nums[i]);
          }
          return dp[d][idx]=max;
       }

       if(dp[d][idx]!=null) return dp[d][idx];
       
        int max=0;
        int ans=Integer.MAX_VALUE;
        for(int k=idx;k<=nums.length-d;k++){
            max=Math.max(max,nums[k]);
            int next=solve(nums,d-1,k+1);
            ans=Math.min(ans,max+next);
        }


        return dp[d][idx]=ans;
    }

}