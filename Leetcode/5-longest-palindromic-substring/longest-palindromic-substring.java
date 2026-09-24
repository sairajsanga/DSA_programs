class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=0;
        boolean dp[][]=new boolean[n+1][n+1];
        int start=0;
        int maxlen=0;
        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=2||dp[i+1][j-1]){
           
                        dp[i][j]=true;
                        if(len>maxlen){
                            maxlen=len;
                            start=i;
                        }
                      
                    }
                }
               
            }
        }

        return s.substring(start,start+maxlen);
    }
}