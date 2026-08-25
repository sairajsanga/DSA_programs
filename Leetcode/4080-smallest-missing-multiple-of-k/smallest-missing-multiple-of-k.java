class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;

        HashSet<Integer> set=new HashSet<>();
        
        for(int ele:nums){
            set.add(ele);
        }

        for(int i=1;i<=101;i++){
            if(!set.contains(k*i)) return k*i;
        }

        return -1;
    }
}