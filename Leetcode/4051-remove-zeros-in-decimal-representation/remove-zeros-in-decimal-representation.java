class Solution {
    public long removeZeros(long n) {
        long  result=0;
        while(n>0){
            long rem=n%10;
            if(rem!=0){
                result=result*10+rem;
            } 
            n/=10;
        }
        return reverse(result);
        
    }
    public long reverse(long num){
        char str[]=Long.toString(num).toCharArray();
        int i=0;
        int j=str.length-1;
        while(i<j){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }

       String res=String.valueOf(str);
       Long ans=Long.parseLong(res);
       return ans;

    }
}