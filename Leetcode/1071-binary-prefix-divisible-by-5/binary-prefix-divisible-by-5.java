class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
       int n=nums.length;
       List<Boolean> result=new ArrayList<>();
       int curr=0;
       for(int i=0;i<n;i++){
         curr=(curr*2+nums[i])%5;
         result.add(curr==0);
       }
       return result;
    }
}