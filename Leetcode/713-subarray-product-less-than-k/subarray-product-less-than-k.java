class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        
        int prod=1;
        int count=0;
        int i=0;

        for(int j=0;j<n;j++){
           prod*=nums[j];
           while(prod>=k&&i<=j){
             prod=prod/nums[i];
             i++;
           }
           count+=j-i+1;
        }

        return count;
    }
}