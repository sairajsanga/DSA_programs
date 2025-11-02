class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        int freq[]=new int[102];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        int result[]=new int[2];
        int idx=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>1){
               result[idx++]=i;
            }
        }
        return result;
    }
}