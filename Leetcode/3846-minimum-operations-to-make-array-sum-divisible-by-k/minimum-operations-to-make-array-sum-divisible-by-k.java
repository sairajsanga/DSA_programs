class Solution {
    public int minOperations(int[] nums, int k) {
       int n=nums.length;
       int rem=0;
       for(int i=0;i<n;i++){
          rem=(rem+nums[i])%k;     
       }
       return rem;
    }
}