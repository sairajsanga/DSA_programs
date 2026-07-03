class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();

        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->b[0]-a[0]);
        boolean visited[][]=new boolean[m][n];
        q.add(new int[]{health-grid.get(0).get(0),0,0});

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int h=curr[0];
            int x=curr[1];
            int y=curr[2];
     
            if(x<0||y<0||x>=m||y>=n||visited[x][y]||h<=0) continue;

            if(x==m-1&&y==n-1) return true;

            System.out.println("x-->"+x+" y-->"+y+ " health-->"+h);

            visited[x][y]=true;
            for(int dir[]:directions){
                int i=x+dir[0];
                int j=y+dir[1];

                if(i<0||j<0||i>=m||j>=n||visited[i][j]||h<=0) continue;

                q.add(new int[]{h-grid.get(i).get(j),i,j});
            }
        }
        return false;
    }
}


/*
[[0,1,0,0,0],
[0,1,0,1,0],
[0,0,0,1,1]]
*/









