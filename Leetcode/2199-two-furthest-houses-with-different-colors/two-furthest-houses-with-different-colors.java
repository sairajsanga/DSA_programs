class Solution {
    public int maxDistance(int[] nums) {
        int n=nums.length;
        

       int max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
         for(int j=n-1;j>=0;j--){
            if(nums[i]!=nums[j]){
                max=Math.max(max,j-i);
            }
         }
       }
       return max;
    }
}