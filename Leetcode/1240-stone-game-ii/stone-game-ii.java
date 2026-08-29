class Solution {

    Integer dp[][][];
    
    public int stoneGameII(int[] piles) {

        int n=piles.length;
        this.dp=new Integer[2][n+1][n+1];
        
        return solve(piles,1,0,1);
    }

    public int solve(int piles[],int person,int idx,int M){

        if(idx>=piles.length) return 0;

        if(dp[person][idx][M]!=null) return dp[person][idx][M];

        int stones=0;
        int result=(person==1)?-1:Integer.MAX_VALUE;

        for(int x=1;x<=Math.min(2*M,piles.length-idx);x++){
            stones+=piles[idx+x-1];
            if(person==1){
                result=Math.max(result,stones+solve(piles,0,idx+x,Math.max(M,x)));
            }else{
                result=Math.min(result,solve(piles,1,idx+x,Math.max(M,x)));
            }
        }

        return dp[person][idx][M]=result;

    }
}