class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int j=0;
        for(int i=2;i<n;i++){
            if(nums[i]==nums[i-1]+nums[i-2]){
                max=Math.max(max,i-j+1);
            }
            else{
               j=i-1;
            }
        }
        return max==Integer.MIN_VALUE?2:max;
    }
}