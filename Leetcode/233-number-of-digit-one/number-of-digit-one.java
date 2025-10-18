class Solution {
    int dp[][][];
    String num;
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        num = String.valueOf(n);
        int len = num.length();
        dp=new int[len+1][2][len+1];
        for(int i=0;i<=len;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<=len;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(String.valueOf(n), 0, 1, 0);
    }
    public int solve(String s,int index,int flag,int cnt){
         if(index==s.length()){
            return cnt;
         }
         if(dp[index][flag][cnt]!=-1){
            return dp[index][flag][cnt];
         }
         int ans=0;
         int limit=(flag==1?s.charAt(index)-'0':9);
         for(int i=0;i<=limit;i++){
            int updatecnt=cnt+(i==1?1:0);
            int newFlag = (flag == 1 && i == s.charAt(index) - '0') ? 1 : 0;
            ans+=solve(s,index+1,newFlag,updatecnt);
         }
         return dp[index][flag][cnt]=ans;
    }
}