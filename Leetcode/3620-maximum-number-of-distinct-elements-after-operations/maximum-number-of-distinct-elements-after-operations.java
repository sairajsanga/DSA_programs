class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=-k;
        int prev=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<n;i++){
           int minval=nums[i]-k;
           if(prev<minval){
               prev=minval;
               count++;
           }
           else if(prev<nums[i]+k){ 
              prev=prev+1;
              count++;
           }
        }
        return count;    
    }
}