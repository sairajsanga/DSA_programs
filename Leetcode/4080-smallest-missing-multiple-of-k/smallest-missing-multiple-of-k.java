class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int ele:nums){
            set.add(ele);
            if(ele>max) max=ele;
        }

        int n=nums.length;
        for(int i=1;i<=max+1;i++){
            int multiple=k*i;
            if(!set.contains(multiple)){
                return multiple;
            }
        }
        return -1;
    }
}