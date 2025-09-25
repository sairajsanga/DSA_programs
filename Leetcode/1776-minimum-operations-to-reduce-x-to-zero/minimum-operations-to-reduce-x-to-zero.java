class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int ele:nums){
           total+=ele;
        }
        int i=0;
        int j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(j<nums.length){
           sum+=nums[j];
           if(sum>total-x){
            while(i<=j&&sum>total-x){
                sum-=nums[i];
                i++;
            }
           }
            if(sum==total-x){
                max=Math.max(max,j-i+1);
            }
            j++;   
        }
        return (max==Integer.MIN_VALUE)?-1:nums.length-max;
    }
}