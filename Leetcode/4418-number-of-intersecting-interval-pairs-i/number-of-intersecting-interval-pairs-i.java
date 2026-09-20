class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(intervals[j][0]<=intervals[i][1]){
                    count++;
                }
            }
        }
        
        return count;
    }
}