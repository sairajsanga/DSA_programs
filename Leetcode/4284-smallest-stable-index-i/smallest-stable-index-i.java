class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;

      
        int prefix[]=new int[n];
        int suffix[]=new int [n];
        int max=nums[0];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            prefix[i]=max;
        }
        System.out.println(Arrays.toString(prefix));
        
        int min=nums[n-1];
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
           min=Math.min(min,nums[i]);
           suffix[i]=min;  
        }
        System.out.println(Arrays.toString(suffix));
        
        for(int i=0;i<n;i++){
            int Max=prefix[i];
            int Min=suffix[i];

            if(Max-Min<=k) return i;
        }

        return -1;
    }
}