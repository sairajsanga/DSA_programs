class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
          set.add(nums[i]);
          if(nums[i]<min){
            min=nums[i];
          }
          if(nums[i]>max){
            max=nums[i];
          }
        }
        for(int i=min+1;i<max;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}