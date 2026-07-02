class Solution {
    int m;
    int n;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
       this.m=grid.size();
       this.n=grid.get(0).size();

       PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
       int dist[][]=new int[m][n];
       for(int i=0;i<m;i++) Arrays.fill(dist[i],-1);
       q.offer(new int[]{0,0,grid.get(0).get(0)});

       int directions[][]={
           {0,1},
           {0,-1},
           {1,0},
           {-1,0}
       };
       while(!q.isEmpty()){
          int curr[]=q.poll();

          int i=curr[0];
          int j=curr[1];
          int val=curr[2];

          if(dist[i][j]>=0) continue;
          dist[i][j]=val;
          for(int dir[]:directions){
              int x=i+dir[0];
              int y=j+dir[1];
              
              if(x<0||y<0||x>=m||y>=n) continue;
              if(dist[x][y]>=0) continue;

              q.offer(new int[]{x,y,val+grid.get(x).get(y)});
          }
       }
       return dist[m-1][n-1]<health;
    }
   
}