class Solution {
    int n;
    int m;
    int directions[][];
    boolean visited[][];
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.n=grid.length;
        this.m=grid[0].length;

        this.visited=new boolean[n][m];
        this.directions=new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        if (n == 0) return 0;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                     bfs(grid,i,j);
                     count++;
                }
            }
        }
        return count;
    }


    public void bfs(char grid[][],int i,int j){
        

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});

        visited[i][j]=true;

        while(!q.isEmpty()){
            int curr[]=q.poll();
            
            for(int dir[]:directions){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];


                if(r>=0 && r<n && c>=0 && c<m && grid[r][c]=='1' && !visited[r][c]){
                    visited[r][c]=true;
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}