class Solution {
    public int countElements(int[] nums, int k) {
        int n=nums.length;
        if(k==0) return n;
        Arrays.sort(nums);
      
        int limit=nums[n-k];
        int count=0;
        for(int ele:nums){
            if(ele<limit) count++;
        }
        return count;

    }
}