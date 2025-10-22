class Solution {
    public int maxFrequency(int[] nums, int k, int numOps) {
        int n=nums.length;
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2;
        int[] count = new int[maxVal];
        int original[]=new int[maxVal];
        
        for (int v : nums){
            original[v]++;
        }
        if(numOps==0){
           int fastmax = Arrays.stream(original).max().getAsInt();
           return fastmax;
        }
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            int start=ele-k;
            int end=ele+k;
            if (start < 0) start = 0;
               count[start]+=1;

            if(end+1<maxVal){
                count[end+1]-=1;
            }
        }

        for(int i=1;i<maxVal;i++){
            count[i]+=count[i-1];
        }
        int max=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                int operationsneeded=Math.min(count[i]-original[i],numOps);
                if(operationsneeded<=numOps){
                   max=Math.max(max,original[i]+operationsneeded);
                }
            }
        }
        return max;
    }
}