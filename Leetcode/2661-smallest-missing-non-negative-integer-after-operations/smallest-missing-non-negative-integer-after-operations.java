class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n=nums.length; 
       int result[]=new int[n+value];
       for(int num:nums){
        int rem=(num%value+value)%value;
          result[rem]++;
       }

       for(int i=0;i<=n+value;i++){
          if(result[i%value]>0){
             result[i%value]--;
          }
          else{
            return i;
          }
       }
       return -1;
    }
}