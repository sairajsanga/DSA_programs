class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0&& nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){
            int nextgreaterIndx=getNextGreaterIndex(nums,i);

            swap(nums,i,nextgreaterIndx);
        }

        Arrays.sort(nums,i+1,n);
    }

    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public int getNextGreaterIndex(int nums[],int i){
        int min=Integer.MAX_VALUE;
        int minIdx=0;

        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>nums[i]&&min>nums[j]){
                min=nums[j];
                minIdx=j;
            }
        }

        return minIdx;
    }
}