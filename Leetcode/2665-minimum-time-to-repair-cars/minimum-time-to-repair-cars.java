class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length;

        long max=0;

        for(int ele:ranks){
            if(ele>max){
                max=ele;
            }
        }
   
        long start=1;
        long end=max*cars*cars;

       while(start<=end){
           long mid=start+(end-start)/2;

            if(solve(ranks,mid)>=cars){
                 end=mid-1;
            }else{
                start=mid+1;
            } 
       }

       return start;
    }
    public long solve(int nums[],long minutes){

        long totalcars=0;
        for(int i=0;i<nums.length;i++){
           totalcars+=Math.sqrt(minutes/nums[i]);
        }

        return totalcars;
    }
}