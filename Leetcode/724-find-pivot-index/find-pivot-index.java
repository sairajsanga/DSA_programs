class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[nums.length+1];
        prefix[0]=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        for(int i=1;i<=n;i++){
            if(prefix[i-1]==prefix[n]-prefix[i]){
               return i-1;
            }
        }
        return -1;
    }
}