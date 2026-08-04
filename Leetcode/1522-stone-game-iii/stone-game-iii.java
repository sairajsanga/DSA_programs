class Solution {
    Integer dp[];
    int n;

    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.dp = new Integer[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int res = solve(stoneValue,0);
        if (res > 0)
            return "Alice";
        else if (res == 0)
            return "Tie";
        else
            return "Bob";
    }

    public int solve(int nums[], int i) {
       if(i==n) return 0;

       if(dp[i]!=Integer.MIN_VALUE) return dp[i];

       int score=nums[i]-solve(nums,i+1);
       if(i+1<n){
        score=Math.max(score,nums[i]+nums[i+1]-solve(nums,i+2));
       }
       if(i+2<n){
        score=Math.max(score,nums[i]+nums[i+1]+nums[i+2]-solve(nums,i+3));
       }

       return dp[i]=score;
    }
}