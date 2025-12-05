class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int ele:nums){
            total+=ele;
        }
        int prefix=0;
        int count=0;
        for(int i=0;i<n-1;i++){
           prefix+=nums[i];
           int left=prefix;
           int right=total-prefix;
           int diff=left-right;
           if(diff%2==0) count++;
        }
        return count;
    }
}