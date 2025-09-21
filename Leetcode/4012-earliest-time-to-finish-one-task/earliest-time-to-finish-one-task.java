class Solution {
    public int earliestTime(int[][] tasks) {
       int min=Integer.MAX_VALUE;
       for(int task[]:tasks){
        int sum=0;
        for(int ele:task){
            sum+=ele;
        }
        if(sum<min){
            min=sum;
        }
       }
       return min; 
    }
}