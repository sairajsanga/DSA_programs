class Solution {
    public long sumAndMultiply(int n) {
       long sum=0;
       long total=0;
        while(n!=0){
          int rem=n%10;
          if(rem!=0){
             sum=sum*10+rem;
             total+=rem;
          }
          n=n/10;
        }
        
        long fix=0;
        while(sum>0){
            fix=fix*10+(sum%10);
            sum=sum/10;
        }
        return fix*total;
    }
    // public long reverse(long num){
    //     String s=String.valueOf(num);
    //     StringBuilder str=new StringBuilder(s);
    //     String res=str.reverse().toString();
    //     Long ans=Long.parseLong(res);
    //     return ans;
    // }
}