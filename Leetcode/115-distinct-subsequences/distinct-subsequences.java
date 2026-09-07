class Solution {
    Integer dp[][];
    public int numDistinct(String s, String t) {
        this.dp=new Integer[s.length()+1][t.length()+1];
        return solve(s,0,0,t);
    }
    public int solve(String s,int i,int j,String t){

        if(j==t.length()) return 1;

        if(i==s.length()) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(s,i+1,j+1,t)+solve(s,i+1,j,t);
        }else{
            return dp[i][j]=solve(s,i+1,j,t);
        }
    }


}