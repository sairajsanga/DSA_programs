class Solution {
    public int findLHS(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        while(j<n){
            if(map.containsKey(nums[j]-1)){
                int left=Math.max(map.getOrDefault(nums[j],0)+map.getOrDefault(nums[j]-1,0),max);
                max=Math.max(max,left);
            }
            j++;
        }

        return max;
    }
}