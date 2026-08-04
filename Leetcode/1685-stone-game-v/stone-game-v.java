class Solution {
    int n;
    int nums[];
    Integer dp[][];

    public int stoneGameV(int[] stoneValue) {
        this.n = stoneValue.length;
        this.nums = stoneValue;
        this.dp=new Integer[n+1][n+1];
        int prefix[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }

        return solve(0, n - 1, prefix);
    }

    public int solve(int i,int j,int prefix[]){
        if(i>=j) return 0;

        if(dp[i][j]!=null) return dp[i][j];
        
        int score=0;
        for(int k=i;k<j;k++){
            int first=prefix[k+1]-prefix[i];
            int secound=prefix[j+1]-prefix[k+1];

            if(first>secound){
               score=Math.max(score,secound+solve(k+1,j,prefix));
            }
            else if(first<secound){
               score= Math.max(score,first+solve(i,k,prefix));  
            }
            else{
                score=Math.max(score,first+Math.max(solve(i,k,prefix),solve(k+1,j,prefix)));
            }
        }

        return dp[i][j]=score;
       
    }

}