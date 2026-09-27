class Solution {
    Integer dp[][];
    public int longestPalindromeSubseq(String s) {
        this.dp=new Integer[s.length()+1][s.length()+1];
        return solve(s,0,s.length()-1);
    }

    public int solve(String s,int i,int j){

        if(i>j) return 0;

        if(i==j) return 1;

        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=2+solve(s,i+1,j-1);
        }

        else{
            dp[i][j]=Math.max(
                solve(s,i,j-1),
                solve(s,i+1,j)
            );
        }

        return dp[i][j];
    }

    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}