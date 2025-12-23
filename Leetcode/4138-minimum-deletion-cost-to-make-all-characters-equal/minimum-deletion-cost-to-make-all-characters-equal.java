class Solution {
   
    public long minCost(String s, int[] cost) {
        int n=cost.length;
        long count[]=new long[26];
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']+=cost[i];
        }

       Arrays.sort(count);

       long ans=0;
       for(int i=0;i<25;i++){
           ans+=count[i];  
       }
       return ans;
    }
}