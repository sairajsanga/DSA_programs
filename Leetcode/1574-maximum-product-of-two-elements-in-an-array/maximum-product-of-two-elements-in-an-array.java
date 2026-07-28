class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n1=nums[nums.length-2]-1;
        int n2=nums[nums.length-1]-1;

        return  n1*n2;
    }
}