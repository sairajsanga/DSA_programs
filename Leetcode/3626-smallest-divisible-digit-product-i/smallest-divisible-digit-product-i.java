class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            int ans=getProduct(i);
            if(ans%t==0) return i;
        }
        return -1;
    }
    public int getProduct(int n){
        int prod=1;
        while(n!=0){
            int rem=n%10;
            prod=prod*rem;
            n=n/10;
        }

        return prod;
    }
}