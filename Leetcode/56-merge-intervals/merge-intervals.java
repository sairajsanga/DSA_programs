class Solution {
    public int[][] merge(int[][] intervals) {
        
        int m=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int current[]=intervals[0];
        List<int[]> list=new ArrayList<>();

        for(int i=1;i<m;i++){
            if(intervals[i][0]<=current[1]){
                current[1]=Math.max(intervals[i][1],current[1]);
            }
           else{
              list.add(current);
              current=intervals[i];
           }
        }

        list.add(current);
        return list.toArray(new int[list.size()][]);
    }
}