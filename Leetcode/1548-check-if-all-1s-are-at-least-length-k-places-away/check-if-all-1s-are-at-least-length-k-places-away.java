class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        if(k==0) return true;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                for(int j=i+1;j<n;j++){
                    if(nums[j]==1){
                        int dist=j-i-1;
                        if(dist<k){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}