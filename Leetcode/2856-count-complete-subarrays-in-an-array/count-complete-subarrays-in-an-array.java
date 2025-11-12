class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        int target=set.size();
        int count=0;
        for(int i=0;i<n;i++){
          HashSet<Integer> set2=new HashSet<>();
            for(int j=i;j<n;j++){
               set2.add(nums[j]);
               if(set2.size()==target) count++;
            }
        }
        return count;
    }
}