class Solution {
    public long countCommas(long n) {
       
       long commas=1;
       long lower=1000;
       long result=0;
       while(lower<=n){
          long higher=lower*1000-1;

          if(higher>n) higher=n;

          long countNumbers=higher-lower+1;

          result+=countNumbers*commas;
          lower=lower*1000;
          commas++;
       }
       return result;
    }
}