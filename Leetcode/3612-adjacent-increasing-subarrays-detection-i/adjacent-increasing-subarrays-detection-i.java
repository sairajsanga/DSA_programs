class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       int n=nums.size();

       for(int i=0;i+2*k<=n;i++){
           if(getValid(nums,i,i+k)&&getValid(nums,i+k,i+2*k)){
              return true;
           }  
       }
       return false;
    }
    public boolean getValid(List<Integer> nums, int i, int j) {
    // If subarray length is 1, it's trivially increasing
    if (j - i <= 1) return true;

    for (int x = i; x < j - 1; x++) {  // stop at j-1 to avoid out-of-bounds
        if (nums.get(x) >= nums.get(x + 1)) return false;
    }
    return true;
}
}