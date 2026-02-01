class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int ele:nums){
            total+=ele;
        }
        if(n==3) return total;
        
        int fixed=nums[0];
        Arrays.sort(nums,1,n);
        int ans=fixed+nums[1]+nums[2];
        return ans;
    }
}