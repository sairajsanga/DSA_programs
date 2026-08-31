class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;

        long pricesum[]=new long[n+1];
        long profitsum[]=new long[n+1];

        for(int i=0;i<n;i++){
            pricesum[i+1] = pricesum[i] + (long) prices[i];
            profitsum[i+1] = profitsum[i] + (long) prices[i] * strategy[i];
        }
        long max=profitsum[n];
        for(int i=0;i+k<=n;i++){
            int mid=i+k/2;
            long oldprofit=profitsum[i+k]-profitsum[i];
            long newprofit=pricesum[i+k]-pricesum[mid];
            long val= profitsum[n]-oldprofit+newprofit;
            max=Math.max(max,val); 
        }
        return max;
    }
}