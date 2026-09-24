class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
       this.dp=new Boolean [n+1][m+1];
       return solve(s,p,0,0);

    }

    public boolean solve(String s,String p,int i ,int j){

        if (i == s.length() && j == p.length()) {
           return dp[i][j]=true;
        }

        if (j == p.length()) {
           return dp[i][j]=false;
        }

        if(i==s.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*') return dp[i][j]=false;
            }
            return dp[i][j]=true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        char ch=p.charAt(j);

        if(ch=='*'){
            boolean skipStar=solve(s,p,i,j+1);
            boolean useStar=solve(s,p,i+1,j);

            return dp[i][j]=skipStar||useStar;
        }
        else if(ch=='?'||s.charAt(i)==ch){
            return dp[i][j]=solve(s,p,i+1,j+1);
        }


        return dp[i][j]=false;
    }

}