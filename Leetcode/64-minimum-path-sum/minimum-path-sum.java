class Solution {
    int dist[][];
    int directions[][];
    int m;
    int n;
    public int minPathSum(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.directions=new int[][]{
            {0,1},
            {1,0}
        };

        this.dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        solve(grid,0,0);

        return dist[m-1][n-1]==Integer.MAX_VALUE?-1:dist[m-1][n-1]+grid[0][0];
    }

    public void solve(int grid[][],int startR,int startC){

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        dist[startR][startC]=0;
        q.add(new int[]{startR,startC,0});
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int row=curr[0];
            int col=curr[1];
            int cost=curr[2];

            if(cost>dist[row][col]) continue;

            for(int dir[]:directions){
                int newR=row+dir[0];
                int newC=col+dir[1];

                if(newR<0||newC<0||newR>=m||newC>=n) continue;

                int newCost=cost+grid[newR][newC];

                if(newCost<dist[newR][newC]){
                    dist[newR][newC]=newCost;
                    q.add(new int[]{newR,newC,newCost});
                }
            }
        } 
    }
}