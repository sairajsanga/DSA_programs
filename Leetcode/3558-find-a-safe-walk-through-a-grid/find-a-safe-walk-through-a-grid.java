class Solution {
    private record Pair(int h,int x,int y){}; 
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();

        int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};

        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->b.h-a.h);
        boolean visited[][]=new boolean[m][n];
        q.add(new Pair(health-grid.get(0).get(0),0,0));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int h=curr.h;
            int x=curr.x;
            int y=curr.y;
     
            if(x<0||y<0||x>=m||y>=n||visited[x][y]||h<=0) continue;

            if(x==m-1&&y==n-1) return true;

            System.out.println("x-->"+x+" y-->"+y+ " health-->"+h);

            visited[x][y]=true;
            for(int dir[]:directions){
                int i=x+dir[0];
                int j=y+dir[1];

                if(i<0||j<0||i>=m||j>=n||visited[i][j]||h<=0) continue;

                q.add(new Pair(h-grid.get(i).get(j),i,j));
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









