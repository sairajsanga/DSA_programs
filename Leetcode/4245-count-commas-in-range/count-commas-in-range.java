class Solution {
    public int countCommas(int n) {
       
       String s=Integer.toString(n);

       int digits=s.length();
       if(digits<4) return 0;
       int count=0;
       for(int i=1000;i<=n;i++){
           if(i<=100000){
            count+=1;
           }
           else {
            count+=2;
           }
       }
       return count;
    }
}