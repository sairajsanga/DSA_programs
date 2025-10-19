class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        int n=nums.length;
        for(int i=1;i<=101;i++){
            int multiple=k*i;
            if(!set.contains(multiple)){
                return multiple;
            }
        }
        return -1;
    }
}