class Solution {
    public int alternatingSum(int[] nums) {
        int n=nums.length;
        int esum=0;
        int osum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                esum+=nums[i];
            }
            else{
                osum+=nums[i];
            }
        }
        return esum-osum;
    }
}