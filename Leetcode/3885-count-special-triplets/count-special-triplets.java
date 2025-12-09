class Solution {
    int MOD=(int)1e9+7;
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> right=new HashMap<>();
        HashMap<Integer,Integer> left=new HashMap<>();

        for(int i=0;i<n;i++){
            right.put(nums[i],right.getOrDefault(nums[i],0)+1);
        }
        long count=0;
        for(int i=0;i<n;i++){
           right.put(nums[i],right.getOrDefault(nums[i],0)-1);
           int num=nums[i]*2;
           long rightcount=right.getOrDefault(num,0);
           long leftcount=left.getOrDefault(num,0);

           count+=(leftcount*rightcount)%MOD;
          
           left.put(nums[i],left.getOrDefault(nums[i],0)+1);
        }
        return (int)(count%MOD);
    }
}