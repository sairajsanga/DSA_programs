class Solution {
    public long minArraySum(int[] nums) {
        
        int n=nums.length;

        int max=0;
        for(int ele:nums){
            max=Math.max(max,ele);
        }
        boolean ispresent[]=new boolean[max+1];
        for(int ele:nums){
            ispresent[ele]=true;
        }
        
        int arr[]=new int[max+1];
        for(int i=1;i<=max;i++){
            if(ispresent[i]){
                 for(int j=i;j<=max;j+=i){
                    if(arr[j]==0){
                       arr[j]=i;
                    }
                     
                 }
            }
        }
        
        long sum=0;
        for(int num:nums){
           sum+=arr[num];
        }


        return sum;
    }


    
}