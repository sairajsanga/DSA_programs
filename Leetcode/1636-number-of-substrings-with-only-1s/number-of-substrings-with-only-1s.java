class Solution {
    
    public int numSub(String s) {
       final int MOD = 1000000007;
       int n=s.length();
       long res=0;
       long count=0;
       for(int i=0;i<n;i++){
         if(s.charAt(i)=='1'){
            count++;
         } 
         else{
            res+=(count*(count+1))/2; 
            res%=MOD;
            count=0;
         } 
       }
        res+=(count*(count+1))/2; 
        res%=MOD;
       return (int)res;  
    }
}