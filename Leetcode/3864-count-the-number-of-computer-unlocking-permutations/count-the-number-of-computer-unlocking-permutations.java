class Solution {
    int MOD=(int)1e9+7;
    public int countPermutations(int[] nums) {
        int n=nums.length;
        int ele=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<=ele) return 0;
        }

        return factorial(n-1);
        
    }
   public int factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result = (result * i) % MOD;
    }
    return (int) result;
}
}