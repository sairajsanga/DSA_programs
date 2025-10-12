class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        int max = 0;
        int zeroes=0;
        while (j < n) { 
          if(nums[j]==0){
            zeroes++;
          }  
          while(zeroes>k){
            if(nums[i]==0){
                zeroes--;
            }
            i++;
          }
            max=Math.max(max,j-i+1);
           j++;
        }
        return max;
    }
}