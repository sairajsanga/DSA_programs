class Solution {
    public int longestSubsequence(int[] nums) {
      boolean allzero=true;
      int xor=0;
      for(int i=0;i<nums.length;i++){
        xor^=nums[i];
        if(nums[i]!=0) allzero=false;
      }
      if(allzero) return 0;
      return xor!=0?nums.length:nums.length-1;
    }
}