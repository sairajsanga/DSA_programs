class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;

        int drops=0;

        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[(i+1)%n]){
                drops++;
            }
            if(drops>1) return false;
        }

        if(nums[0]<nums[n-1]) drops++;

        return drops<=1;
    }
}