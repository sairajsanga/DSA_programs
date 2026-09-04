class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int n=weights.length;
        int total=0;
        int start=0;
        for(int ele:weights){
            total+=ele;
            start=Math.max(start,ele);
        }

        int end=total; 

        while(start<=end){
            int mid=start+(end-start)/2;
            // if mid is min capacity of ship how days it takes;
            if(solve(weights,mid)<=days){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        
        return start;
    }

    public int solve(int nums[],int min){
        int n=nums.length;

        int days=1;
        int weights=0;
        for(int i=0;i<n;i++){
            if(weights+nums[i]>min){
                days++;
                weights=nums[i];
            }else{
                weights+=nums[i];
            }
        }

        System.out.println(days);

        return days;
    }

    
}