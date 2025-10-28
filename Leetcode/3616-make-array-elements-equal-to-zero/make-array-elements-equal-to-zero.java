class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int result=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int left=prefix[i];
                int right=prefix[n-1]-left;
                if(left==right){
                    result+=2;
                }
                else if(left==right-1){
                    result+=1;
                }
                else if(right==left-1){
                    result+=1;
                }
            }
        }
        return result;
    }
}