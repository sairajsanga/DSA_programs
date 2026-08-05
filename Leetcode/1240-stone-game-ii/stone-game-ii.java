class Solution {
    int suffix[];
    Integer dp[][];
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        this.suffix=new int[n+1];
        this.dp=new Integer[n][n+1];

        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+piles[i];
        }
        return solve(piles,0,1);
    }

    public int solve(int []piles,int index,int m){
        
        if(index>=piles.length) return 0;

        if(2*m>=piles.length-index) return suffix[index];

        if(dp[index][m]!=null) return dp[index][m];

        int score=0;
        for(int i=1;i<=2*m;i++){
           score=Math.max(score,suffix[index]-solve(piles,index+i,Math.max(m,i)));
        }
        return dp[index][m]=score;
    }
}