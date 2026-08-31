class Solution {
    int dp[];

    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int max=Integer.MIN_VALUE;

        this.dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);

        for(int i=0;i<n;i++){
           max=Math.max(max,solve(energy,i,k));
        }
        return max;
    }

    public int solve(int nums[],int idx,int k){

        if(idx>=nums.length) return 0;

        if(dp[idx]!=Integer.MIN_VALUE) return dp[idx];


        int take=nums[idx]+solve(nums,idx+k,k);
    
        
        return dp[idx]=take;
    }
}