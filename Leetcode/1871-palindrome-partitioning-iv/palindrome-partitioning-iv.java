class Solution {
    Boolean dp[][];
    boolean preCompute[][];
    public boolean checkPartitioning(String s) {
        int n=s.length();
       this.dp=new Boolean[n+1][4];
       this.preCompute=new boolean[n+1][n+1];

       for(int len=1;len<=n;len++){
        for(int i=0;i+len<=n;i++){
            int j=i+len-1;

            if(s.charAt(i)==s.charAt(j)&& (len<=2||preCompute[i+1][j-1])){
                preCompute[i][j]=true;
            }
        }
       }


       return solve(s,0,3);
    }

    public boolean solve(String s,int idx,int limit){
        if(limit==0){
            return dp[idx][limit]=idx==s.length();
        }

        if(idx==s.length()) return dp[idx][limit]=false;

        if(dp[idx][limit]!=null) return dp[idx][limit];

        for(int k=idx;k<s.length();k++){
            if(preCompute[idx][k]){
                if(solve(s,k+1,limit-1)) return dp[idx][limit]=true;

            }
        }
        return dp[idx][limit]=false;
    }


    public boolean isPalindrome(String s,int i ,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}