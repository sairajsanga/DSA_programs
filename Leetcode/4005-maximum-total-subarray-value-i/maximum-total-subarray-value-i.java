class Solution {
    public long maxTotalValue(int[] nums, int k) {
        //add
        Arrays.sort(nums);
        long min=(long)nums[0];
        long max=(long)nums[nums.length-1];

        long ans=(max-min)*k;
        return ans;  
    }
}