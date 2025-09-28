class Solution {
    public long splitArray(int[] nums) {
        long prefix[]=new long[nums.length+1];
        boolean inc[]=new boolean[nums.length];
        boolean dec[]=new boolean[nums.length];
        for(int i=1;i<=nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        inc[0]=true;
        for(int i=1;i<nums.length;i++){
           if(nums[i-1]<nums[i]&&inc[i-1]){
            inc[i]=true;
           }
           else inc[i]=false;
        }
        dec[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]&&dec[i+1]){
                dec[i]=true;
            }
            else{
                dec[i]=false;
            }
        }
        long min=Long.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(inc[i]&&dec[i+1]){
           long left=prefix[i+1];
           long right=prefix[nums.length]-left;
           long diff=Math.abs(left-right);
           min=Math.min(min,diff);
            }
        }
        return min==Long.MAX_VALUE?-1:min;
    }
}