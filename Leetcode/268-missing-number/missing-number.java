class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int ele:nums){
            total+=ele;
        }

        return n*(n+1)/2-total;
    }
}