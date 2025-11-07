class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return solve(nums,k)-solve(nums,k-1);
    }
    public int solve(int nums[],int k){
        int n=nums.length;
       int i=0;
       int j=0;
       HashMap<Integer,Integer> map=new HashMap<>();
       int count=0;
       while(j<n){
          map.put(nums[j],map.getOrDefault(nums[j],0)+1);
          while(map.size()>k){
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            if(map.get(nums[i])==0){
                map.remove(nums[i]);
            }
            i++;
          }
          count+=j-i+1;
          j++;
       } 
       return count;
    }
}