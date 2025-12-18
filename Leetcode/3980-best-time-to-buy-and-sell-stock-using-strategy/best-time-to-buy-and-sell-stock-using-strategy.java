class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long pricesum[]=new long[n+1];
        long profitsum[]=new long[n+1];
        for(int p=0;p<n;p++){
           pricesum[p+1]=pricesum[p]+(long)prices[p];
           profitsum[p+1]=profitsum[p]+(long)prices[p]*strategy[p];
        }
        long max=profitsum[n];
        for(int i=0;i+k<=n;i++){
            int mid=i+k/2;
            long oldprofit=profitsum[i+k]-profitsum[i];
            long newprofit=pricesum[i+k]-pricesum[mid];
            long val=(profitsum[n]-oldprofit)+newprofit;
            max=Math.max(max,val);
        }
        return max;
    }
}