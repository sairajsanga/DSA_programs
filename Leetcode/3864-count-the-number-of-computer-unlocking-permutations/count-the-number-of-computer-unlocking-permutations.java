class Solution {
    int MOD=(int)1e9+7;
    public int countPermutations(int[] nums) {
        int n=nums.length;
        boolean flag=false;
       
        int ele=nums[0];
        HashSet<Integer> set=new HashSet<>();
        set.add(ele);
        for(int i=1;i<n;i++){
            if(set.contains(nums[i])||nums[i]<ele){
                flag=true;
                break;
            }
        }

        if(!flag) return factorial(n-1)%MOD;
        return 0;
        
    }
   public int factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result = (result * i) % MOD;
    }
    return (int) result;
}
}