class Solution {
    public int repeatedNTimes(int[] nums) {
        int size=nums.length;
        int n=size/2;

        int count[]=new int[10001];

        for(int i=0;i<size;i++){
            count[nums[i]]++;
            if(count[nums[i]]==n) return nums[i];
        }

        
        return 0;
    }
}