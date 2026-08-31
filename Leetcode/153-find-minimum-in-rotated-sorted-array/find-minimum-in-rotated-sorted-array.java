class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int pivot=-1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) {
                pivot=i;
                break;
            }
        }

        return nums[pivot+1];
        
    }
}