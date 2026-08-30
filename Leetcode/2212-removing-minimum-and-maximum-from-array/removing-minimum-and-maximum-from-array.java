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
        System.out.println(min+" "+minidx+" "+max+" "+maxidx+" ");
        int total=0;
        if(minidx!=-1&& maxidx!=-1){
            if(maxidx<minidx){
                int first=minidx+1;
                int secound=n-maxidx;
                int third=(maxidx+1)+(n-minidx);
                total=Math.min(Math.min(first,secound),third);
            }else{
                int first=maxidx+1;
                int secound=n-minidx;
                int third=(minidx+1)+(n-maxidx);
                total=Math.min(Math.min(first,secound),third);
            }
        }
        return total;
    }
}