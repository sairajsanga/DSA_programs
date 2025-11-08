class Solution {
    public long maxSpending(int[][] values) {
        int m=values.length;
        int n=values[0].length;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 q.add(values[i][j]);
            }
        }
        long day=1;
        long res=0;
        while(!q.isEmpty()){
            int val=q.poll();
            res=res+val*day;
            day++;
        }
        return (long)res;
    }
}