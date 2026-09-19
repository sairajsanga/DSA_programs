class Solution {
    public int minCapability(int[] nums, int k) {
        int n=nums.length;
        int max=-1;
        for(int ele:nums) max=Math.max(max,ele);
        int start=1;
        int end=max;
        while(start<end){
            int mid=start+(end-start)/2;

            if(canRob(nums,k,mid)){
                end=mid;
            }
            else{
               start=mid+1;
            }
        }

        return start;
    }

    public boolean canRob(int[] nums, int k, int cap) {

        int count = 0;

        for (int i = 0; i < nums.length; ) {

            if (nums[i] <= cap) {
               count++;
               i += 2;
            }else {
               i++;
            }

            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}