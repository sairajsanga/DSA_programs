class Solution {
    Boolean dp[][];
    public boolean checkValidString(String s) {
        int n=s.length();
        
        this.dp =new Boolean[n+1][n+1];
        return solve(s,0,0);
    }

    public boolean solve(String s,int idx,int open){

        if(open<0) return false;

        if(idx==s.length()){
            return dp[idx][open]=open==0;
        }

        if(dp[idx][open]!=null) return dp[idx][open];

        char ch=s.charAt(idx);
        boolean ans=false;
        if(ch=='('){
            ans= solve(s,idx+1,open+1);
        }else if(ch==')'){
            ans=solve(s,idx+1,open-1);
        }
        else{
            ans=solve(s,idx+1,open+1)||solve(s,idx+1,open-1)||solve(s,idx+1,open);
        }

        return dp[idx][open]=ans;
    }
}