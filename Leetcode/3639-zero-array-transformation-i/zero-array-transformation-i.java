class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
       int n=nums.length;
       int result[]=new int[n];
       for(int q[]:queries){
        int start=q[0];
        int end=q[1];
         result[start]++;
         if(end+1<n){
            result[end+1]--;
         }
       }
       for(int i=1;i<n;i++){
         result[i]+=result[i-1];
       }
       for(int i=0;i<n;i++){
          result[i]=nums[i]-result[i];
          if(result[i]<0) result[i]=0;
          if(result[i]>0) return false;
       }

       return true;  
    }
}