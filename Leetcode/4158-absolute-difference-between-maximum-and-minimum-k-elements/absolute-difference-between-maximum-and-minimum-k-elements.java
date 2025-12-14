class Solution {
    public int absDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int minsum=0;
        for(int i=0;i<n&&i<k;i++){
            minsum+=nums[i];
        }
        int maxsum=0;
        for(int i=n-1;i>=n-k;i--){
           maxsum+=nums[i];
        }

        return maxsum-minsum;
    }
}