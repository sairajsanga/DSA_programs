class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       int n=nums.size();
       int prev=0;
       int  current=1;
       int min=0;
       for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                current++;
            }
            else{
                prev=current;
                current=1;
            }
            if(current/2>=k){
                return true;
            }
            
            if(Math.min(prev,current)>=k){
                return true;
            }
       } 
       return false;

    }
}