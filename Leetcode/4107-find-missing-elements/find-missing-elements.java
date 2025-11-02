class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int start=nums[0];
        int end=nums[n-1];
        HashSet<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
          set.add(nums[i]);
        }
        for(int i=start+1;i<end;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}