class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       int n=intervals.length;
       int newstart=newInterval[0];
       int newend=newInterval[1];
       List<int[]> result = new ArrayList<>();
       int i = 0;

        // Add all intervals before newInterval
       while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

       // Merge all overlapping intervals
       while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
           newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
           newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
           i++;
        }
          result.add(newInterval);

        // Add remaining intervals
        while (i < intervals.length) {
           result.add(intervals[i++]);
         }
          return result.toArray(new int[result.size()][]);
    }
}