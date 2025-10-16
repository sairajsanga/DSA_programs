class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int prev=0;
        int current=1;
        int min=0;
        int res=0;
        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                current++;
            }
            else{
                prev=current;
                current=1;
            }
            int half=current/2;
            min=current<prev?current:prev;
            int tempans=Math.max(half,min);
            if(tempans>res){
                res=tempans;
            }
        }
        return res;
    }
}