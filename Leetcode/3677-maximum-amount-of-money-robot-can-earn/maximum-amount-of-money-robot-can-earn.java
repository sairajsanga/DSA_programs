class Solution {
    
    public int maximumAmount(int[][] coins) {
        int m=coins.length;
        int n=coins[0].length;
        
        int memo[][][]=new int[m][n][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j],Integer.MIN_VALUE);
            }
        }


        return helper(coins,memo,0,0,2);
    }

    public int helper(int coins[][],int memo[][][],int i,int j,int k){
        int m=coins.length;
        int n=coins[0].length;

        if(i>=m||j>=n){
            return Integer.MIN_VALUE;
        }

        int x=coins[i][j];

        if(i==m-1&&j==n-1){
           return k>0?Math.max(0,x):x;
        } 

        if(memo[i][j][k]!=Integer.MIN_VALUE){
            return memo[i][j][k];
        }

        int res=Math.max(helper(coins,memo,i,j+1,k),
                         helper(coins,memo,i+1,j,k))+x;
        
        int skip=Integer.MIN_VALUE;
        if(k>0&&x<0){

            int skipright=helper(coins,memo,i,j+1,k-1);
            int skipdown=helper(coins,memo,i+1,j,k-1);

            skip=Math.max(skipright,skipdown);
        }


        return memo[i][j][k]=Math.max(res,skip);
    }
}