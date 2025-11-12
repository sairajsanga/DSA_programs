class Solution {
    public int minOperations(int[] nums) {
       int n=nums.length;
       int num1=0;
       int g=0;
       for(int x:nums){
           if(x==1) num1++;
           g=gcd(g,x);
       }
       if(num1>0){
        return n-num1;
       }
       if(g>1){
         return -1;
       }

       int minLen=n;
       for(int i=0;i<n;i++){
        int currgcd=0;
        for(int j=i;j<n;j++){
            currgcd=gcd(currgcd,nums[j]);
            if(currgcd==1){
                minLen=Math.min(minLen,j-i+1);
                break;
            }
        }
       }
       return minLen+n-2;     
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return (b==0)?a:-1;
    }
}