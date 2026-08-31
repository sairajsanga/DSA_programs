class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;

        if(n==1) return 1;

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int minidx=-1;
        int maxidx=-1;
        for(int i=0;i<n;i++){
           if(max<nums[i]){
            max=nums[i];
            maxidx=i;
           }if(min>nums[i]){
            min=nums[i];
            minidx=i;
           }
        }
      
        int a=Math.min(minidx,maxidx);
        int b =Math.max(minidx,maxidx);
         int front=b+1;
         int back=n-a;
         int both=(a+1)+(n-b);
         return Math.min(front,Math.min(back,both));
        
    }
}