class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n=nums.length;

        int result[]=new int[2*n];

        for(int i=0;i<n;i++){
            result[i]=result[2*n-i-1]=nums[i];
        }
        return result;
    }
}