class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;

        return solve(nums,0,n-1)>=0;
    }

    public int solve(int nums[],int i, int j){
        if(i>j) return 0;

        if(i==j) return nums[i]; 

        int left=nums[i]-solve(nums,i+1,j);
        int right=nums[j]-solve(nums,i,j-1);

        return Math.max(left,right);
    }
}