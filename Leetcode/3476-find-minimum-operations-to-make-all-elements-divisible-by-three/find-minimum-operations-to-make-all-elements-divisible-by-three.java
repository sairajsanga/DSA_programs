class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
           count+=Math.min(nums[i]%3,1); 
        }
        return count;
    }
}